package com.codecool.eventPlanner.model.entity;


import com.codecool.eventPlanner.model.dto.EventDTO;
import com.codecool.eventPlanner.model.dto.NewEventDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name="events")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateTime;
    private String location;
    @ManyToOne
    @JsonBackReference
    private User creator;
    private String description;
    @ManyToMany()
    private Set<User> interestedUsers;
    @ManyToMany()
    private Set<Category> categories;
    private String title;

    public Event(NewEventDTO eventDTO){
        this.categories = eventDTO.categories();
        this.dateTime = eventDTO.dateTime();
        this.location = eventDTO.location();
        this.creator = eventDTO.creator();
        this.description = eventDTO.description();
        this.interestedUsers = eventDTO.interestedUsers();
        this.title = eventDTO.title();
    }

    public void update(EventDTO eventDTO){
        this.categories = eventDTO.getCategories();
        this.dateTime = eventDTO.getDateTime();
        this.location = eventDTO.getLocation();
        this.creator = eventDTO.getCreator();
        this.description = eventDTO.getDescription();
        this.interestedUsers = eventDTO.getInterestedUsers();
        this.title = eventDTO.getTitle();
    }
}
