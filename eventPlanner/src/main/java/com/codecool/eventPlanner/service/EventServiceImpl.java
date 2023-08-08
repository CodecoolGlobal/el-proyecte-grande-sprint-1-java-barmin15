package com.codecool.eventPlanner.service;


import com.codecool.eventPlanner.model.dto.CategoryIdsDTO;
import com.codecool.eventPlanner.model.dto.EventDTO;
import com.codecool.eventPlanner.model.dto.NewEventDTO;
import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.repository.CategoryRepository;

import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;

import com.codecool.eventPlanner.repository.EventRepository;
import com.codecool.eventPlanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {
  private final CategoryRepository categoryRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired

    public EventServiceImpl(CategoryRepository categoryRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
    this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void addUserForEvent(Long userId, Long eventId) {
        User user = userRepository.findById(userId).get();
        Event modifiedEvent = eventRepository.findById(eventId).get();
        Set<User> interestedUsers = modifiedEvent.getInterestedUsers();
        interestedUsers.add(user);
        eventRepository.save(modifiedEvent);
    }



    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

   /* @Override
    public List<Event> getEventsByCategories(CategoryIdsDTO categoryIdsDTO) {
        Set<Category> categories = Arrays.stream(categoryIdsDTO.categoryIds())
                .map(id -> categoryRepository.findById(id).get()).collect(Collectors.toSet());
        return eventRepository.getEventsByCategories(categories);
    }*/


         }


    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public Event updateEvent(Long id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id).get();
        event.update(eventDTO);
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event createEvent(NewEventDTO newEventDTO) {
        Event event = new Event(newEventDTO);
        eventRepository.save(event);
        return event;
    }

    @Override
    public List<Event> getEventsByUser(Long id) {
       return (List<Event>) userRepository.findById(id).get().getInterestedEvents();
    }

    @Override
    public List<Event> getCreatedEventsByUser(Long id) {
        return (List<Event>) userRepository.findById(id).get().getCreatedEvents();
    }
}
