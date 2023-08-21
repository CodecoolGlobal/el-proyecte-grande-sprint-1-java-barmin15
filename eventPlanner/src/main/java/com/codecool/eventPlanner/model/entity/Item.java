package com.codecool.eventPlanner.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "items")
    @JsonBackReference
    private Set<Event> events;

    @PreRemove
    private void removeAssociations() {
        for (Event event : this.events) {
            event.getItems().remove(this);
        }
    }
}
