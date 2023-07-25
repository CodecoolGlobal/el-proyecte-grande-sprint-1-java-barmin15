package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.EventDTO;
import com.codecool.eventPlanner.model.NewEventDTO;
import com.codecool.eventPlanner.model.UpdateEventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();

    EventDTO getEventById(int id);

    List<EventDTO> getEventsByCategories(List<Integer> categoryIds);

    boolean createEvent(NewEventDTO newEventDTO);

    boolean deleteEvent(int id);

    boolean updateEvent(UpdateEventDTO updateEventDTO);
}
