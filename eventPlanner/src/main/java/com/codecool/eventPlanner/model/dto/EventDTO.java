package com.codecool.eventPlanner.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class EventDTO {
    private Long id;
    private String dateTime;
    private String location;
    private Long creatorId;
    private String description;
    private Long[] interestedUsersIds;
    private Long[] categoriesId;
    private String title;
}

