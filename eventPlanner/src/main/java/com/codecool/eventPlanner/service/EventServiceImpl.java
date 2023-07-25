package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.EventDTO;
import com.codecool.eventPlanner.model.NewEventDTO;
import com.codecool.eventPlanner.model.UpdateEventDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Override
    public EventDTO getEvent(int id) {
        return null;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return null;
    }

    @Override
    public EventDTO getEventById(int id) {
        return null;
    }

    @Override
    public List<EventDTO> getEventsByCategories(List<Integer> categoryIds) {
        return null;
    }

    @Override
    public boolean createEvent(NewEventDTO newEventDTO) {
        return false;
    }

    @Override
    public boolean deleteEvent(int id) {
        return false;
    }

    @Override
    public boolean updateEvent(UpdateEventDTO updateEventDTO) {
        return false;
    }
}
