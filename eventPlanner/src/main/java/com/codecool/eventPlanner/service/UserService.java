package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.dto.NewUserDTO;
import com.codecool.eventPlanner.model.dto.UpdateUserDTO;
import com.codecool.eventPlanner.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> getUsersByEvent(Long eventId);

    User getCurrentUser();

    boolean addUser(NewUserDTO newUserDTO);

    boolean updateUser(UpdateUserDTO updateUserDTO);
}
