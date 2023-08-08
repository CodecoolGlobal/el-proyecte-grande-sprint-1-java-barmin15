package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.repository.EventRepository;
import com.codecool.eventPlanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
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
    public Event getEventById(Long id) {
        return eventRepository.findById(id).get();
    }
}
