package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void addUserForEvent(User user, Event event) {
        Event modifiedEvent = eventRepository.findById(event.getId()).get();
        Set<User> interestedUsers = modifiedEvent.getInterestedUsers();
        interestedUsers.add(user);
        //modifiedEvent.setInterestedUsers(interestedUsers);
        eventRepository.save(modifiedEvent);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).get();
    }
}
