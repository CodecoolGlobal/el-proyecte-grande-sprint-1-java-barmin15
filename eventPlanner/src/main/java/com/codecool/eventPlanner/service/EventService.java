package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {

    List<Event> getAllEvents();

    void addUserForEvent(User user, Event event);

    Event getEventById(Long id);
}
