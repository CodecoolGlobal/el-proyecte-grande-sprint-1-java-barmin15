package com.codecool.eventPlanner.model.dto.event;

import java.sql.Time;
import java.util.Date;

public record UpdateEventDTO(
        int id,
        String name,
        String description,
        Date date,
        Time time
) {
}
