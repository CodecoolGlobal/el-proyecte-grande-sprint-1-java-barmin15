package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String auth = authentication.getName();
            auth = auth.substring(auth.indexOf("=") + 1);
            auth = auth.substring(0, auth.indexOf(","));
            return userService.getUserById(Long.parseLong(auth));
        } else {
            throw new RuntimeException("No User");
        }
    }

    @GetMapping("/interested/{eventId}")
    public Set<User> getInterestedUsersByEventId(@PathVariable Long eventId) {
        return userService.getInterestedUsersByEventId(eventId);
    }
}










