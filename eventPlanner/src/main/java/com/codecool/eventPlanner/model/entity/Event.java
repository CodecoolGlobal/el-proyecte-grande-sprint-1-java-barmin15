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
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User admin;
    private String description;
    @ManyToMany
    private Set<Category> categorys;
    private String title;



}
