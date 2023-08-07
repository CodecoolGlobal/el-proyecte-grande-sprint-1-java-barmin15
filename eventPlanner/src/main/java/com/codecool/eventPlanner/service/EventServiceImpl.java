package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.jpa.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl {
    private EventRepo eventRepo;

    @Autowired
    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }
}
