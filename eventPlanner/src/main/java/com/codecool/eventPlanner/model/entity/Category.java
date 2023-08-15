package com.codecool.eventPlanner.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Remove;

import java.util.Set;

@Entity(name = "categories")
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

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    Set<Event> events;

    @PreRemove
    private void removeAssociations() {
        for (Event event : this.events) {
            event.getCategories().remove(this);
        }
    }
}
