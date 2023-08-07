package com.codecool.eventPlanner.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
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
    private User creator;
    private String description;
    @ManyToMany(mappedBy = "interestedEvents")
    private Set<User> interestedUsers;
    @ManyToMany()
    private Set<Category> categories;
    private String title;
}
