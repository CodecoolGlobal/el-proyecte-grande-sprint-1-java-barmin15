package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.dto.UserToEventDTO;
import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PutMapping
    public void addUserForEvent(@RequestBody UserToEventDTO userToEventDTO) {
        eventService.addUserForEvent(userToEventDTO.userId(), userToEventDTO.eventId());
    }

    @GetMapping("{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }
}
