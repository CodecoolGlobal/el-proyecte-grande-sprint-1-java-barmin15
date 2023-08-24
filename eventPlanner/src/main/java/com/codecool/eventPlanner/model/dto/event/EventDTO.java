package com.codecool.eventPlanner.model.dto.event;

import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventDTO {
    private Long id;
    private String date;
    private String time;
    private String[] categories;
    private String location;
    private Long creatorId;
    private String creatorName;
    private String description;
    private String[] interestedUsers;
    private Long[] interestedUsersIds;
    private Long[] categoriesId;
    private String title;
}

