package com.codecool.eventPlanner.model;

import java.util.Date;

public record UpdateEventDTO(
        int id,
        String name,
        String description,
        Date date
) {
}
