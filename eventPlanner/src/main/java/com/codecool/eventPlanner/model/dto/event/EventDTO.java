package com.codecool.eventPlanner.model.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

