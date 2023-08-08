package com.codecool.eventPlanner.repository;


import com.codecool.eventPlanner.model.entity.Category;

import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    //List<Event> getEventsByCategories(Set<Category> categories);


}

