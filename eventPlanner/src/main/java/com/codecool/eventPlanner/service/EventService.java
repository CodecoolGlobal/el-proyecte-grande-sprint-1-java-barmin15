package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<Event> getAllEvents();

    void addUserForEvent(Long userId, Long eventId);

    Event getEventById(Long id);
}
