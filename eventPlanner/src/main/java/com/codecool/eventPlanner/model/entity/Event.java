package com.codecool.eventPlanner.model.entity;


import com.codecool.eventPlanner.model.dto.EventDTO;
import com.codecool.eventPlanner.model.dto.NewEventDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;
import java.util.Set;

@Entity(name = "events")
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
    @ManyToOne()
    @JsonBackReference
    private User creator;
    private String description;
    @ManyToMany()
    @JsonBackReference
    private Set<User> interestedUsers;
    @ManyToMany(mappedBy = "events")
    @JsonBackReference
    private Set<Category> categories;
    private String title;

    public Event(NewEventDTO eventDTO) {

        this.categories = eventDTO.categories();
        //categories.add(new Category());
        this.dateTime = eventDTO.dateTime();
        this.location = eventDTO.location();
        this.creator = eventDTO.creator();
        this.description = eventDTO.description();
        this.interestedUsers = eventDTO.interestedUsers();
        this.title = eventDTO.title();
    }

    public void update(EventDTO eventDTO) {

        this.categories = Optional.ofNullable(eventDTO.getCategories()).orElse(this.categories);
        this.dateTime = Optional.ofNullable(eventDTO.getDateTime()).orElse(this.dateTime);
        this.location = Optional.ofNullable(eventDTO.getLocation()).orElse(this.location);
        this.creator = Optional.ofNullable(eventDTO.getCreator()).orElse(this.creator);
        this.description = Optional.ofNullable(eventDTO.getDescription()).orElse(this.description);
        this.interestedUsers = Optional.ofNullable(eventDTO.getInterestedUsers()).orElse(this.interestedUsers);
        this.title = Optional.ofNullable(eventDTO.getTitle()).orElse(this.title);
       // categories.add(new Category());
    }
}
