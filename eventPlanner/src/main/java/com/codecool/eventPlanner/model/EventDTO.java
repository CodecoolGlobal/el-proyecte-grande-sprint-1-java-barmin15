package com.codecool.eventPlanner.model;


import java.util.Date;

public record EventDTO(
        int id,
        int creatorId,
        String name,
        String description,
        Date date,
        String location,
        boolean isPrivate
) {
}
