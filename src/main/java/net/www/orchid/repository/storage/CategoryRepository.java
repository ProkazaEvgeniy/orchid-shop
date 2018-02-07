package net.www.orchid.repository.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import net.www.orchid.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
