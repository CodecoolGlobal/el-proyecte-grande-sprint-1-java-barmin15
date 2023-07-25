package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.NewUserDTO;
import com.codecool.eventPlanner.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public UserDTO getUserById(int id) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean createUser(NewUserDTO userDTO) {
        return false;
    }
}
