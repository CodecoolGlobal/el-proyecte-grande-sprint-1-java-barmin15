package com.codecool.eventPlanner.service;


import com.codecool.eventPlanner.model.dto.CategoryIdsDTO;
import com.codecool.eventPlanner.model.dto.EventDTO;
import com.codecool.eventPlanner.model.dto.NewEventDTO;

import com.codecool.eventPlanner.model.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface EventService {

    List<Event> getAllEvents();

    void addUserForEvent(Long userId, Long eventId);

    void deleteEvent(Long id);

    Set<Event> getEventsByCategories(CategoryIdsDTO categoryIdsDTO);

    Event getEventById(Long id);

    Event updateEvent(Long id, EventDTO eventDTO);

    Event createEvent(NewEventDTO newEventDTO);

    Set<Event> getEventsByUser(Long id);

    Set<Event> getCreatedEventsByUser(Long id);


}