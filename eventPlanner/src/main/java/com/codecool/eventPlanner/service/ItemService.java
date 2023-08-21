package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.dto.item.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<ItemDTO> getAllItems();

    Long saveItem(String name);
}
