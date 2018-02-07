package net.www.orchid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.www.orchid.entity.Product;
import net.www.orchid.repository.storage.ProductRepository;
import net.www.orchid.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public long countAllProduct() {
		return productRepository.count();
	}
	
	@Override
	public List<Product> allProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product oneProductByID(Long id) {
		return productRepository.findOne(id);
	}
	
	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

}
