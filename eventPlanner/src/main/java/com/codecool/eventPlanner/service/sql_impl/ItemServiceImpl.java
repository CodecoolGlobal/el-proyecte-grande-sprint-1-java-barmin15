package com.codecool.eventPlanner.service.sql_impl;

import com.codecool.eventPlanner.model.dto.item.ItemDTO;
import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.Item;
import com.codecool.eventPlanner.repository.ItemRepository;
import com.codecool.eventPlanner.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemDTO( item.getId(),item.getName())).toList();
    }

    @Override
    public Long saveItem(String name) {
        boolean isExists = itemRepository.existsByName(name);
        if (!isExists) {
            Item item = Item.builder().name(name).build();
            itemRepository.save(item);
            return item.getId();
        }
        Item item = itemRepository.findByName(name);
        return item.getId();
    }
}
