package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.dto.NewUserDTO;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

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
    public List<User> getUsersByEvent(@PathVariable Long eventId){
        return userService.getUsersByEvent(eventId);
    }

    @GetMapping("/current")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

    @PostMapping
    public boolean addUser(@RequestBody NewUserDTO newUserDTO){
        return userService.addUser(newUserDTO);
    }

}










