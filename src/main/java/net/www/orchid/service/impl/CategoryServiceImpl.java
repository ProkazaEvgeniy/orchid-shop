package net.www.orchid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.www.orchid.entity.Category;
import net.www.orchid.repository.storage.CategoryRepository;
import net.www.orchid.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> allCategory() {
		return categoryRepository.findAll();
	}
}
