package com.codecool.eventPlanner.service.sql_impl;

import com.codecool.eventPlanner.repository.CategoryRepository;
import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Long addNewCategory(String categoryName) {
        boolean isExists = categoryRepository.existsByName(categoryName);
        if (!isExists) {
            Category category = Category.builder().name(categoryName).build();
            categoryRepository.save(category);
            return category.getId();
        }
        Category category1 = categoryRepository.findByName(categoryName);
        return category1.getId();
    }

    @Transactional
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
