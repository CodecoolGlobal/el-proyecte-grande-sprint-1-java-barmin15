package com.codecool.eventPlanner.model.entity;

import com.codecool.eventPlanner.model.dto.event.EventDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    @Basic
    @Temporal(TemporalType.TIME)
    private java.util.Date time;
    //private String dateTime;

    private String location;


    @Column(columnDefinition = "TEXT")
    private String description;
    private String title;

    @ManyToOne()
    @JsonBackReference
    private User creator;

    @ManyToMany()
    @JsonBackReference
    private Set<User> interestedUsers;

    @ManyToMany()
    @JsonManagedReference
    private Set<Category> categories;

    @ManyToMany
    @JsonBackReference
    private Set<Item> items;

    public void update(EventDTO eventDTO, User creator, Set<User> interestedUsers, Set<Category> categories){
        this.categories.addAll(Optional.ofNullable(categories).orElse(this.categories));
        try {
            this.date = Optional.ofNullable(new SimpleDateFormat("yyyy-MM-dd").parse(eventDTO.getDate())).orElse(this.date);
            this.time = Optional.ofNullable(new SimpleDateFormat("HH:mm:ss").parse(eventDTO.getTime())).orElse(this.time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.location = Optional.ofNullable(eventDTO.getLocation()).orElse(this.location);
        this.creator = Optional.ofNullable(creator).orElse(this.creator);
        this.description = Optional.ofNullable(eventDTO.getDescription()).orElse(this.description);
        this.interestedUsers.addAll(Optional.ofNullable(interestedUsers).orElse(this.interestedUsers));
        this.title = Optional.ofNullable(eventDTO.getTitle()).orElse(this.title);
    }
}
