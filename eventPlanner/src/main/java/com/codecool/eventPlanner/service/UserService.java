package com.codecool.eventPlanner.service;


import com.codecool.eventPlanner.model.NewUserDTO;
import com.codecool.eventPlanner.model.UserDTO;

import java.util.List;

public interface UserService {
    boolean updateUser(UserDTO userDTO);

    UserDTO getUserById(int id);

    List<UserDTO> getAll();

    boolean delete(int id);

    boolean createUser(NewUserDTO userDTO);

    UserDTO getCurrentUser();
}
