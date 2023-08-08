package com.codecool.eventPlanner.model.dto;

public record CategoryDTO(String name) {
    public CategoryDTO(String name) {
        this.name = name;
    }
}
