package com.codecool.eventPlanner.model;


import java.util.Date;

public class EventDTO{

        private int id;
        private int creatorId;
        private String name;
        private String description;
        private Date date;
        private String location;
        private boolean isPrivate;

    public EventDTO(int id, int creatorId, String name, String description, Date date, String location, boolean isPrivate) {
        this.id = id;
        this.creatorId = creatorId;
        this.name = name;
        this.description = description;
        this.date = date;
        this.location = location;
        this.isPrivate = isPrivate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}

