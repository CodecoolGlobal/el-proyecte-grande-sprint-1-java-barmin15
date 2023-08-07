package com.codecool.eventPlanner.service;


import com.codecool.eventPlanner.model.dto.NewUserDTO;
import com.codecool.eventPlanner.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    boolean updateUser(UserDTO userDTO);

    UserDTO getUserById(int id);

    List<UserDTO> getAll();

    boolean delete(int id);

    boolean createUser(NewUserDTO userDTO);

    boolean logInUser(String username, String password);
    UserDTO getCurrentUser();

}
