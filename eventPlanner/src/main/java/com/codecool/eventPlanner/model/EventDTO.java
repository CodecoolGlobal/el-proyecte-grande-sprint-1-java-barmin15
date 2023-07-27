package com.codecool.eventPlanner.model;


import java.sql.Time;
import java.util.Date;

public record EventDTO(
        int id,
        int creatorId,
        String name,
        String description,
        Date date,
        Time time,
        String location,
        boolean isPrivate
) {
}
