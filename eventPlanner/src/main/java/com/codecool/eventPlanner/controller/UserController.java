package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.model.NewUserDTO;
import com.codecool.eventPlanner.model.UserDTO;
import com.codecool.eventPlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody int id) {
        return userService.delete(id);
    }

    @PostMapping()
    public boolean createUser(@RequestBody NewUserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
}








