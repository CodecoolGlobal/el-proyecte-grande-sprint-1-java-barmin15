package com.codecool.eventPlanner.repository;

import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
