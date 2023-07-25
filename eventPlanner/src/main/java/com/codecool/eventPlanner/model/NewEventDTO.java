package com.codecool.eventPlanner.model;


import java.util.Date;

public record NewEventDTO(
        int creatorId,
        String name,
        String description,
        Date date,
        String location,
        boolean isPrivate
) {
}
