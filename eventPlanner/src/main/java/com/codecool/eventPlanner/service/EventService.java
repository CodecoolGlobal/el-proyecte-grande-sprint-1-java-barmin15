package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.EventDTO;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    public EventDTO getEvent(int id);
}
