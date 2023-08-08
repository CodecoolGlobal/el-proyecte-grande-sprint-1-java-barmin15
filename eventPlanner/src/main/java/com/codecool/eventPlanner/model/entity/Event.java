package com.codecool.eventPlanner.model.entity;

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
    @ManyToMany(mappedBy = "interestedEvents")
    private Set<User> interestedUsers;
    @ManyToMany()
    private Set<Category> categories;
    private String title;
}
