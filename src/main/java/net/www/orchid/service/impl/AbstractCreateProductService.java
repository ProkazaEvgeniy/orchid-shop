package net.www.orchid.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import net.www.orchid.entity.Category;
import net.www.orchid.entity.Lenght;
import net.www.orchid.entity.Producer;
import net.www.orchid.entity.Product;
import net.www.orchid.model.UploadResult;
import net.www.orchid.service.ImageProcessorService;

public abstract class AbstractCreateProductService {

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ImageProcessorService imageProcessorService;
	
	protected Product createNewProduct(String name, Category category, Producer producer, BigDecimal price, String description,
			Lenght lenght, Integer count, MultipartFile uploadPhoto) {
		UploadResult uploadResult = imageProcessorService.processNewProductPhoto(uploadPhoto);
		Product product = new Product();
		product.setCount(count);
		product.setName(name);
		product.setCategory(category);
		product.setProducer(producer);
		product.setPrice(price);
		product.setDescription(description);
		product.setLenght(lenght);
		product.setPhoto(uploadResult.getUrl());
		return product;
	}
	
	protected Lenght createNewLenght(Integer name){
		Lenght lenght = new Lenght();
		lenght.setName(name);
		return lenght;
	}
	
	protected Producer createNewProducer(String name){
		Producer producer = new Producer();
		producer.setName(name);
		return producer;
	}
	
	protected Category createNewCategory(String name, String url){
		Category category = new Category();
		category.setName(name);
		category.setUrl(url);
		return category;
	}
}
