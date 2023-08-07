package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.jpa.CategoryRepo;
import com.codecool.eventPlanner.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    @Override
    public List<Category> allCategories() {
        return categoryRepo.findAll();
    }
}
