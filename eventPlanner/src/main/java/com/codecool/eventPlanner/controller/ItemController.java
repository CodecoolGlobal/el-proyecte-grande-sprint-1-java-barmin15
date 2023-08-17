package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.dto.item.ItemDTO;
import com.codecool.eventPlanner.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping()
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/save/{name}")
    public Long saveItem(@PathVariable String name){
        return itemService.saveItem(name);
    }
}
