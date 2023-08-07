package com.codecool.eventPlanner.model.dto;

public record UserDTO(
        int id,
        String username,
        String description,
        String password
) {
}
