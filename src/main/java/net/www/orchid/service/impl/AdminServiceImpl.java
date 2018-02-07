package net.www.orchid.service.impl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.multipart.MultipartFile;

import net.www.orchid.service.ImageStorageService;
import net.www.orchid.Constants;
import net.www.orchid.annotation.CategoryDataFieldGroup;
import net.www.orchid.annotation.ProducerDataFieldGroup;
import net.www.orchid.annotation.ProductDataFieldGroup;
import net.www.orchid.entity.Category;
import net.www.orchid.entity.Lenght;
import net.www.orchid.entity.Producer;
import net.www.orchid.entity.Product;
import net.www.orchid.form.CategoryForm;
import net.www.orchid.form.LenghtForm;
import net.www.orchid.form.ProducerForm;
import net.www.orchid.form.ProductForm;
import net.www.orchid.model.UploadResult;
import net.www.orchid.repository.search.ProductSearchRepository;
import net.www.orchid.repository.storage.CategoryRepository;
import net.www.orchid.repository.storage.LenghtRepository;
import net.www.orchid.repository.storage.ProducerRepository;
import net.www.orchid.repository.storage.ProductRepository;
import net.www.orchid.service.AdminService;
import net.www.orchid.service.ImageProcessorService;
import net.www.orchid.util.DataUtil;

@Service
public class AdminServiceImpl extends AbstractCreateProductService implements AdminService {

	@Autowired
	private ProducerRepository producerRepository;

	@Autowired
	private LenghtRepository lenghtRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductSearchRepository productSearchRepository;

	@Autowired
	private ImageProcessorService imageProcessorService;

	@Autowired
	private ImageStorageService imageStorageService;

	/**/
	// Lenght
	@Override
	public void addLenght(LenghtForm lenghtForm) {
		Lenght lenght = createNewLenght(lenghtForm.getName());
		lenghtRepository.saveAndFlush(lenght);
	}

	@Override
	public List<Lenght> allLenght() {
		return lenghtRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteLenght(Integer id) {
		lenghtRepository.delete(id);
	}

	// end Lenght
	/**/
	// Producer
	@Override
	public void addProducer(ProducerForm producerForm) {
		Producer producer = createNewProducer(producerForm.getName());
		producerRepository.saveAndFlush(producer);
	}

	@Override
	public List<Producer> allProducer() {
		return producerRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteProducer(Long id) {
		producerRepository.delete(id);
	}

	@Override
	public Producer oneProducerByID(Long id) {
		return producerRepository.findOne(id);
	}

	@Override
	@Transactional
	public void updateProducer(Long id, Producer producerForm) {
		Producer loaderProducer = producerRepository.findOne(id);
		int copiedFieldsCount = DataUtil.copyFields(producerForm, loaderProducer, ProducerDataFieldGroup.class);
		boolean shouldProfileBeUpdated = copiedFieldsCount > 0;
		if (shouldProfileBeUpdated) {
			producerRepository.saveAndFlush(loaderProducer);
		} else {
			LOGGER.debug("Category not updated");
		}
	}
	// end Producer

	// Category
	@Override
	public void addCategory(CategoryForm categoryForm) {
		Category category = createNewCategory(categoryForm.getName(), categoryForm.getUrl());
		categoryRepository.saveAndFlush(category);
	}

	@Override
	public List<Category> allCategory() {
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteCategory(Long id) {
		categoryRepository.delete(id);
	}

	@Override
	public Category oneCategoryByID(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	@Transactional
	public void updateCategory(Long id, Category categoryForm) {
		Category loaderCategory = categoryRepository.findOne(id);
		int copiedFieldsCount = DataUtil.copyFields(categoryForm, loaderCategory, CategoryDataFieldGroup.class);
		boolean shouldProfileBeUpdated = copiedFieldsCount > 0;
		if (shouldProfileBeUpdated) {
			categoryRepository.saveAndFlush(loaderCategory);
		} else {
			LOGGER.debug("Category not updated");
		}

	}
	// end Category

	// Product
	@Override
	public void createdProductData(ProductForm productForm, MultipartFile uploadPhoto) {
		Product product = createNewProduct(productForm.getName(), productForm.getCategory(), productForm.getProducer(),
				productForm.getPrice(), productForm.getDescription(), productForm.getLenght(), productForm.getCount(),
				uploadPhoto);
		productRepository.saveAndFlush(product);
	}

	@Override
	public Product oneProductByID(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	@Transactional
	public void updateProduct(Long id, Product productForm, MultipartFile uploadPhoto) {
		Product loaderProduct = productRepository.findOne(id);
		List<String> oldProductPhotos = Collections.emptyList();
		if (!uploadPhoto.isEmpty()) {
			UploadResult uploadResult = imageProcessorService.processNewProductPhoto(uploadPhoto);
			deleteUploadedPhotosIfTransactionFailed(uploadResult);
			oldProductPhotos = Arrays.asList(new String[] { loaderProduct.getPhoto() });
			loaderProduct.updateProfilePhotos(uploadResult.getUrl());
		}
		int copiedFieldsCount = DataUtil.copyFields(productForm, loaderProduct, ProductDataFieldGroup.class);
		boolean shouldProfileBeUpdated = !uploadPhoto.isEmpty() || copiedFieldsCount > 0;
		if (shouldProfileBeUpdated) {
			executeUpdateProfileData(id, loaderProduct, oldProductPhotos);
		}
	}
	
	@Override
	public List<Product> allProduct() {
		return productRepository.findAll();
	}
	
	@Override
	@Transactional
	public void deleteProduct(Long id) {
		Product product = productRepository.findOne(id);
		List<String> imageLinksToRemove = getImageLinksToRemove(product);
		productRepository.delete(product);
		removeProfileIndexIfTransactionSuccess(product, imageLinksToRemove);
	}
	
	protected List<String> getImageLinksToRemove(Product product){
		List<String> imageLinksToRemove = new ArrayList<>();
		imageLinksToRemove.add(product.getPhoto());
		return imageLinksToRemove;
	}
	
	protected void removeProfileIndexIfTransactionSuccess(final Product product, final List<String> imageLinksToRemove) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("Product by id=" + product.getId() + " removed from storage");
				productSearchRepository.delete(product.getId());
				imageStorageService.remove(imageLinksToRemove.toArray(new String[imageLinksToRemove.size()]));
				LOGGER.info("Product by id=" + product.getId() + " removed from search index");
			}
		});
	}
	
	// end Product


	protected void executeUpdateProfileData(Long id, Product loaderProduct, List<String> oldProfilePhotos) {
		synchronized (this) {
			productRepository.saveAndFlush(loaderProduct);
		}
		//updateIndexProductDataIfTransactionSuccess(id, loaderProduct, oldProfilePhotos);
	}
	
	protected void updateIndexProductDataIfTransactionSuccess(final Long id, final Product productForm, final List<String> oldProductPhotos) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("Product updated");
				imageStorageService.remove(oldProductPhotos.toArray(Constants.EMPTY_ARRAY));
			}
		});
	}
	
	protected <T extends Annotation> void updateIndexProductData(Long id, Product productForm, Class<T> annotationClass) {
		Product p = productSearchRepository.findOne(id);
		DataUtil.copyFields(productForm, p, annotationClass);
		if (StringUtils.isNotBlank(productForm.getPhoto())) {
			p.setPhoto(productForm.getPhoto());
		}
		productSearchRepository.save(p);
		LOGGER.info("Product index updated");
	}

	protected void deleteUploadedPhotosIfTransactionFailed(final UploadResult uploadResult) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCompletion(int status) {
				if (status == TransactionSynchronization.STATUS_ROLLED_BACK) {
					imageStorageService.remove(uploadResult.getUrl());
				}
			}
		});
	}
}
