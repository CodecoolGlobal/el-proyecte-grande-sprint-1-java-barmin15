package com.codecool.eventPlanner.model;

public record UserDTO(
        int id,
        String username,
        String description,
        String password
) {
}
