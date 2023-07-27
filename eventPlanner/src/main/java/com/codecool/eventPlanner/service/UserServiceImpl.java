package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.NewUserDTO;
import com.codecool.eventPlanner.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private int idCounter = 0;

    private List<UserDTO> allUsers = new ArrayList<>();

    @Override
    public boolean updateUser(UserDTO userDTO) {

        boolean isValidUser = allUsers.stream().filter(u -> u.id() == userDTO.id()).findFirst().isPresent();



        if (isValidUser) {
            UserDTO user = allUsers.stream().filter(u -> u.id() == userDTO.id()).findFirst().get();
            allUsers.remove(user);
            allUsers.add(userDTO);
            return true;
        }
        return false;
    }

    @Override
    public UserDTO getUserById(int id) {
        return allUsers.stream().filter(user -> user.id() == id).findFirst().orElseGet(() -> null);
    }

    @Override
    public List<UserDTO> getAll() {
        return allUsers;
    }

    @Override
    public boolean delete(int id) {
        UserDTO user = allUsers.stream().filter(u -> u.id() == id).findFirst().get();
        return allUsers.remove(user);
    }

    @Override
    public boolean createUser(NewUserDTO userDTO) {
        String name = userDTO.username();
        String pw = userDTO.password();
        String description = userDTO.description();
        allUsers.add(new UserDTO(idCounter, name, description, pw));
        idCounter++;
        return true;
    }

    @Override
    public boolean isAllowed(String username, String password) {
        return allUsers.stream().anyMatch(userDTO -> isValidUser(userDTO, username, password));
    }

    @Override
    public UserDTO getCurrentUser() {
        return new UserDTO(100, "user17353", "hi i'm user17353 :-)", "cicamica");
    }



    private boolean isValidUser(UserDTO userDTO, String username, String password) {
        return userDTO.username().equals(username) && userDTO.password().equals(password);
    }
}
