package com.codecool.eventPlanner.repository;

import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsByName(String name);

    Item findByName(String name);
}
