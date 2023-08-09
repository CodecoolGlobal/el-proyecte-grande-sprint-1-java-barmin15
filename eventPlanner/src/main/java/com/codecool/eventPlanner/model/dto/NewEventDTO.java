package com.codecool.eventPlanner.model.dto;


import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.User;
import lombok.Getter;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

public record NewEventDTO(
        String dateTime,
        String location,
        Long userId,
        String description,
        Long[] categoryIds,
        String title
) {
}
