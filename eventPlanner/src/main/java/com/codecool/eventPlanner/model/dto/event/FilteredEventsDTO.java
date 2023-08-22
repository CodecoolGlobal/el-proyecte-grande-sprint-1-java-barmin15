package com.codecool.eventPlanner.model.dto.event;

import com.codecool.eventPlanner.model.entity.Event;

import java.util.List;
public record FilteredEventsDTO (int maxLength, List<Event> events){}
