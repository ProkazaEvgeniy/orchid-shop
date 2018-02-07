package net.www.orchid.service;

import java.util.List;

import javax.annotation.Nonnull;

import net.www.orchid.entity.Category;

public interface CategoryService {

	@Nonnull List<Category> allCategory();

}
