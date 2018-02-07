package net.www.orchid.service;

import java.util.List;

import javax.annotation.Nonnull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.www.orchid.entity.Product;

public interface ProductService {
	
	@Nonnull long countAllProduct();
	
	@Nonnull List<Product> allProduct();
	
	@Nonnull Product oneProductByID(Long id);
	
	@Nonnull Page<Product> findAll(@Nonnull Pageable pageable);

}
