package net.www.orchid.service;

import java.util.List;

import javax.annotation.Nonnull;

import org.springframework.web.multipart.MultipartFile;

import net.www.orchid.entity.Category;
import net.www.orchid.entity.Lenght;
import net.www.orchid.entity.Producer;
import net.www.orchid.entity.Product;
import net.www.orchid.form.CategoryForm;
import net.www.orchid.form.LenghtForm;
import net.www.orchid.form.ProducerForm;
import net.www.orchid.form.ProductForm;

public interface AdminService {

	// processing for producer table
	void addProducer(@Nonnull ProducerForm producerForm);
	@Nonnull List<Producer> allProducer();
	void deleteProducer(Long id);
	@Nonnull Producer oneProducerByID(Long id);
	void updateProducer(Long id, @Nonnull Producer producerForm);
	// end processing for producer table
	
	// processing for producer table
	void addLenght(@Nonnull LenghtForm lenghtForm);
	@Nonnull List<Lenght> allLenght();
	void deleteLenght(Integer id);
	// end processing for producer table
	
	// processing for category table
	void addCategory(@Nonnull CategoryForm categoryForm);
	@Nonnull List<Category> allCategory();
	void deleteCategory(Long id);
	@Nonnull Category oneCategoryByID(Long id);
	void updateCategory(Long id, @Nonnull Category categoryForm);
	// end processing for category table
	
	// processing for product table
	void createdProductData(@Nonnull ProductForm productForm, @Nonnull MultipartFile uploadPhoto);
	@Nonnull Product oneProductByID(Long id);
	void updateProduct(@Nonnull Long id, @Nonnull Product productForm, @Nonnull MultipartFile uploadPhoto);
	@Nonnull List<Product> allProduct();
	void deleteProduct(Long id);
	// end processing for product table
}