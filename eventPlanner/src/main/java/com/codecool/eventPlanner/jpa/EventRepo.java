package com.codecool.eventPlanner.jpa;

import com.codecool.eventPlanner.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
