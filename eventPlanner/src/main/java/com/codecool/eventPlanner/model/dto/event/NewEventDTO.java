package com.codecool.eventPlanner.model.dto.event;


import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.User;
import lombok.Getter;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

public record NewEventDTO(
        String date,
        String time,
        String location,
        Long userId,
        String description,
        Long[] categoryIds,
        String title
) {
}
