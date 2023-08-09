package com.codecool.eventPlanner.model.dto;


import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.User;
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
    private User creator;
    private String description;
    private Set<User> interestedUsers;
    private Set<Category> categories;
    private String title;


}

