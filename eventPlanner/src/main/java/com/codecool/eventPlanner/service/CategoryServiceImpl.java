package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.repository.CategoryRepository;
import com.codecool.eventPlanner.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
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
        return categoryRepository.findAll();
    }

    @Override
    public Long addNewCategory(Category category) {
        boolean isExists = categoryRepository.existsByName(category.getName());

        if (!isExists) {
            categoryRepository.save(category);
            return category.getId();
        }
        Category category1 = categoryRepository.findByName(category.getName());
        return category1.getId();
    }
}
