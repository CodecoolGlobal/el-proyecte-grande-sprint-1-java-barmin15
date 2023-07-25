package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.NewUserDTO;
import com.codecool.eventPlanner.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<UserDTO> allUsers = new ArrayList<>();


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
        String name = userDTO.username();
        String pw = userDTO.password();
        allUsers.add(new UserDTO(0, name, pw));
        return true;
    }



}
