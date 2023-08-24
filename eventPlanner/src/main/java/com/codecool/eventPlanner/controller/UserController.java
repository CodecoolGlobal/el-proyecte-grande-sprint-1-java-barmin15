package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/event/{eventId}")
    public List<User> getUsersByEvent(@PathVariable Long eventId) {
        return userService.getUsersByEvent(eventId);
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @GetMapping("/interested/{eventId}")
    public Set<User> getInterestedUsersByEventId(@PathVariable Long eventId) {
        return userService.getInterestedUsersByEventId(eventId);
    }
}










