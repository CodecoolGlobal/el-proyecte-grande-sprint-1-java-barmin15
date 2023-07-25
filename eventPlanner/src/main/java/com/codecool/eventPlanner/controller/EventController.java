package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.EventDTO;
import com.codecool.eventPlanner.model.NewEventDTO;
import com.codecool.eventPlanner.model.UpdateEventDTO;
import com.codecool.eventPlanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/event")
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public List<EventDTO> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public EventDTO getEventById(@PathVariable int id){
        return eventService.getEventById(id);
    }

    @GetMapping("/category")
    public List<EventDTO> getEventsByCategories(@RequestBody List<Integer> categoryIds) {
        return eventService.getEventsByCategories(categoryIds);
    }

    @PostMapping()
    public boolean createEvent(@RequestBody NewEventDTO newEventDTO) {
        return eventService.createEvent(newEventDTO);
    }

    @PutMapping
    public boolean updateEvent(@RequestBody UpdateEventDTO updateEventDTO) {
        return eventService.updateEvent(updateEventDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEvent(@PathVariable int id) {
        return eventService.deleteEvent(id);
    }


}
