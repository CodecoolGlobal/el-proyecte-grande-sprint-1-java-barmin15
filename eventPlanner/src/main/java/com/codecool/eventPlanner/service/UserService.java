package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);
}
