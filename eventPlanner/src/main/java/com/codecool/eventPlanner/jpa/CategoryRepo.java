package com.codecool.eventPlanner.jpa;

import com.codecool.eventPlanner.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepo extends JpaRepository<Category, Long> {

}
