package com.codecool.eventPlanner.model.dto;


import java.sql.Time;
import java.util.Date;

public record NewEventDTO(
        int creatorId,
        String name,
        String description,
        Date date,
        Time time,
        String location,
        boolean isPrivate
) {
}
