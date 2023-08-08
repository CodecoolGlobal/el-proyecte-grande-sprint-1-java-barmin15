package com.codecool.eventPlanner.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String lastOnline;
    private String registrationDate;
    @OneToMany(mappedBy = "creator")
    @JsonManagedReference
    private Set<Event> createdEvents;
    @ManyToMany(mappedBy = "interestedUsers")
    private Set<Event> interestedEvents;
}
