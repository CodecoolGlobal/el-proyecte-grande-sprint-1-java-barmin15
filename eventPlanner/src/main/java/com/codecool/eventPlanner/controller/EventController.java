package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.dto.CategoryIdsDTO;
import com.codecool.eventPlanner.model.dto.EventDTO;
import com.codecool.eventPlanner.model.dto.NewEventDTO;
import com.codecool.eventPlanner.model.dto.UserToEventDTO;
import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   /* @GetMapping()
    public List<Event> getEventsByCategories(@RequestBody CategoryIdsDTO categoryIdsDTO) {
        return eventService.getEventsByCategories(categoryIdsDTO);
    }*/

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

    @PostMapping()
    public Event createEvent(@RequestBody NewEventDTO newEventDTO) {
        return eventService.createEvent(newEventDTO);
    }


    @GetMapping("{id}")
    public List<Event> getEventsByUserId(@PathVariable Long id) {
        return eventService.getEventsByUser(id);
    }

    @GetMapping("{id}")
    public List<Event> getCreatedEventsByUser(@PathVariable Long id) {
        return eventService.getCreatedEventsByUser(id);
    }


}
