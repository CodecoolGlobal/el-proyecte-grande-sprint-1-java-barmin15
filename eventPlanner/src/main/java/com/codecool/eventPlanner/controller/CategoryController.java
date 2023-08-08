package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Long addNewCategory(@RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }


}
