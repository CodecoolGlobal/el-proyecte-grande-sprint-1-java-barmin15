package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.dto.category.CategoryIdsDTO;
import com.codecool.eventPlanner.model.dto.event.EventDTO;
import com.codecool.eventPlanner.model.dto.event.NewEventDTO;


import com.codecool.eventPlanner.model.dto.event.UserToEventDTO;
import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

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

    @GetMapping("/byCategories")
    public Set<Event> getEventsByCategories(@RequestBody CategoryIdsDTO categoryIdsDTO) {
        return eventService.getEventsByCategories(categoryIdsDTO);
    }

    @GetMapping("/limit/{num}")
    public List<Event> findAllLimit(@PathVariable int num){ return eventService.findAllLimit(num);}

    @DeleteMapping("{id}")
    public void deleteEventById(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PutMapping("{id}")
    public Event updateEventById(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(id, eventDTO);
    }

    @GetMapping("/interested/{userId}")
    public Set<Event> getEventsByUserId(@PathVariable Long userId) {
        return eventService.getEventsByUser(userId);
    }

    @GetMapping("/creator/{userId}")
    public Set<Event> getCreatedEventsByUser(@PathVariable Long userId) {
        return eventService.getCreatedEventsByUser(userId);
    }

    @PostMapping()
    public Event createEvent(@RequestBody NewEventDTO newEventDTO) {
        return eventService.createEvent(newEventDTO);
    }

}
