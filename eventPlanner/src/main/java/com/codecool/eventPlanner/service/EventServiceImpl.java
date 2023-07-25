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
                .filter(event -> event.id() == id).findFirst().get();
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

        Optional<EventDTO> event = allEvents.stream().filter(e -> e.id() == id).findFirst();

        if (event.isPresent()) {
            allEvents.remove(event);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEvent(UpdateEventDTO updateEventDTO) {

        Optional<EventDTO> event = allEvents.stream()
                .filter(eventDTO -> eventDTO.id() == updateEventDTO.id())
                .findFirst();

        int id = updateEventDTO.id();
        String name = updateEventDTO.name();
        String description = updateEventDTO.description();
        Date date = updateEventDTO.date();
        int creatorId = event.get().creatorId();
        String location = event.get().location();
        boolean isPrivate = event.get().isPrivate();

        EventDTO updatedEventDTO = new EventDTO(id, creatorId, name, description, date, location, isPrivate);

        allEvents.remove(event);
        allEvents.add(updatedEventDTO);

        return true;
    }
}
