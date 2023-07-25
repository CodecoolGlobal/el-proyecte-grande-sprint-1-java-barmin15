package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.NewUserDTO;
import com.codecool.eventPlanner.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private int idCounter = 0;

    private List<UserDTO> allUsers = new ArrayList<>();


    @Override
    public boolean updateUser(UserDTO userDTO) {
        if(allUsers.contains(userDTO)){
            UserDTO user = allUsers.stream().filter(u -> u.id() == userDTO.id()).findFirst().get();
            allUsers.remove(user);
            allUsers.add(userDTO);
        }
        return false;
    }

    @Override
    public UserDTO getUserById(int id) {
        return allUsers.stream().filter(user -> user.id() == id).findFirst().orElseGet(()->null);
    }

    @Override
    public List<UserDTO> getAll() {
        return allUsers;
    }

    @Override
    public boolean delete(int id) {
        UserDTO user = allUsers.stream().filter(u -> u.id() == id).findFirst().orElseGet(()->null);
        return allUsers.remove(user);
    }

    @Override
    public boolean createUser(NewUserDTO userDTO) {
        String name = userDTO.username();
        String pw = userDTO.password();
        allUsers.add(new UserDTO(idCounter, name, pw));
        idCounter++;
        return true;
    }



}
