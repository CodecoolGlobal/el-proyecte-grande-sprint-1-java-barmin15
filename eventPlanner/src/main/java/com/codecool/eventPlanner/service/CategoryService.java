package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public List<Category> getAllCategories();

    Long addNewCategory(Category category);
}
