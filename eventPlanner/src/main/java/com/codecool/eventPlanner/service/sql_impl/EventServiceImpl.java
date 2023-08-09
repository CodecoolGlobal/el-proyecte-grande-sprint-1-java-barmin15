package com.codecool.eventPlanner.service.sql_impl;

import com.codecool.eventPlanner.model.dto.CategoryIdsDTO;
import com.codecool.eventPlanner.model.dto.EventDTO;
import com.codecool.eventPlanner.model.dto.NewEventDTO;
import com.codecool.eventPlanner.model.entity.Category;
import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.repository.CategoryRepository;
import com.codecool.eventPlanner.repository.EventRepository;
import com.codecool.eventPlanner.repository.UserRepository;
import com.codecool.eventPlanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Set<Event> getEventsByCategories(CategoryIdsDTO categoryIdsDTO) {
        Set<Event> event = new HashSet<>();
        for (Long aLong : categoryIdsDTO.categoryIds()) {
            event.addAll(categoryRepository.findById(aLong).get().getEvents());
        }
        return event;
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public Event updateEvent(Long id, EventDTO eventDTO) {
        Set<User> interestedUsers = new HashSet<>();
        Set<Category> categories = new HashSet<>();
        User creator = userRepository.findById(eventDTO.getCreatorId()).get();
        Arrays.stream(eventDTO.getCategoriesId()).forEach(categoryId -> categories.add(categoryRepository.findById(categoryId).get()));
        Arrays.stream(eventDTO.getInterestedUsersIds()).forEach(interestedId -> interestedUsers.add(userRepository.findById(interestedId).get()));

        Event event = eventRepository.findById(id).get();
        event.update(eventDTO, creator, interestedUsers, categories);
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event createEvent(NewEventDTO newEventDTO) {
        Set<Category> categories = new HashSet<>();
        Arrays.stream(newEventDTO.categoryIds()).forEach(id -> {
            Category category = categoryRepository.findById(id).get();
            categories.add(category);
        });

        User creator = userRepository.findById(newEventDTO.userId()).get();

        Event event = Event.builder()
                .creator(creator)
                .title(newEventDTO.title())
                .description(newEventDTO.description())
                .dateTime(newEventDTO.dateTime())
                .location(newEventDTO.location())
                .categories(categories)
                .build();

        eventRepository.save(event);

        return event;
    }

    @Override
    public Set<Event> getEventsByUser(Long id) {
        return userRepository.findById(id).get().getInterestedEvents();
    }

    @Override
    public Set<Event> getCreatedEventsByUser(Long id) {
        return userRepository.findById(id).get().getCreatedEvents();
    }
}
