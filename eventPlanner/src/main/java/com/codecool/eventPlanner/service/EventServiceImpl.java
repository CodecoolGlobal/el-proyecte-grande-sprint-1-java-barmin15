package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.EventDTO;
import com.codecool.eventPlanner.model.NewEventDTO;
import com.codecool.eventPlanner.model.NewUserDTO;
import com.codecool.eventPlanner.model.UpdateEventDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private static int idCounter = 0;

    private List<EventDTO> allEvents = new ArrayList<>();

    @Override
    public List<EventDTO> getAllEvents() {
        return allEvents;
    }

    @Override
    public EventDTO getEventById(int id) {
        return allEvents.stream()
                .filter(event -> event.getId() == id).findFirst().get();
    }

    @Override
    public List<EventDTO> getEventsByCategories(List<Integer> categoryIds) {
        return null;
    }

    @Override
    public boolean createEvent(NewEventDTO newEventDTO) {

        int id = idCounter;
        int creatorId = newEventDTO.creatorId();
        String name = newEventDTO.name();
        String description = newEventDTO.description();
        Date date = newEventDTO.date();
        String location = newEventDTO.location();
        boolean isPrivate = newEventDTO.isPrivate();

        allEvents.add(new EventDTO(id, creatorId, name, description, date, location, isPrivate));

        idCounter++;
        return true;
    }

    @Override
    public boolean deleteEvent(int id) {

        Optional<EventDTO> event = allEvents.stream().filter(e -> e.getId() == id).findFirst();

        if (event.isPresent()) {
            allEvents.remove(event);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEvent(UpdateEventDTO updateEventDTO) {

        Optional<EventDTO> event = allEvents.stream()
                .filter(eventDTO -> eventDTO.getId() == updateEventDTO.id())
                .findFirst();

        event.get().setName(updateEventDTO.name());
        event.get().setDate(updateEventDTO.date());
        event.get().setDescription(updateEventDTO.description());

        return true;
    }
}
