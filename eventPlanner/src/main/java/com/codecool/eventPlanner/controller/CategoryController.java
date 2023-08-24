package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.dto.category.CategoryDTO;
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
    public Long addNewCategory(@RequestBody CategoryDTO category) {
        System.out.println(category.name());
         return categoryService.addNewCategory(category.name());
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
         categoryService.deleteCategory(id);
    }



}
