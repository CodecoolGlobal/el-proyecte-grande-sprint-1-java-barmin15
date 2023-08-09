package com.codecool.eventPlanner.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name="categories")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany()
    @JsonManagedReference
    Set<Event> events;
}
