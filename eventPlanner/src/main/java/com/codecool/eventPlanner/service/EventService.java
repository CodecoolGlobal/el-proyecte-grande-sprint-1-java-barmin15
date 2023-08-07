package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.dto.EventDTO;
import com.codecool.eventPlanner.model.dto.NewEventDTO;
import com.codecool.eventPlanner.model.dto.UpdateEventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();

    EventDTO getEventById(int id);

    List<EventDTO> getEventsByCategories(List<Integer> categoryIds);

    boolean createEvent(NewEventDTO newEventDTO);

    boolean deleteEvent(int id);

    boolean updateEvent(UpdateEventDTO updateEventDTO);
}
