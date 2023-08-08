package com.codecool.eventPlanner.service.old;

import com.codecool.eventPlanner.model.dto.NewUserDTO;
import com.codecool.eventPlanner.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OldUserServiceImpl implements OldUserService {
    private int idCounter = 0;
    private UserDTO currentUser;

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
        UserDTO user = new UserDTO(idCounter, name, description, pw);
        currentUser = user;
        allUsers.add(user);
        idCounter++;
        return true;
    }

    @Override
    public boolean logInUser(String username, String password) {
        currentUser = findUser(username, password);
        return allUsers.stream().anyMatch(userDTO -> isValidUser(userDTO, username, password));
    }

    @Override
    public UserDTO getCurrentUser() {
        return currentUser;
    }


    private boolean isValidUser(UserDTO userDTO, String username, String password) {
        return userDTO.username().equals(username) && userDTO.password().equals(password);
    }

    private UserDTO findUser(String username, String password) {
        return allUsers.stream().filter(userDTO -> isValidUser(userDTO, username, password)).findFirst().get();
    }
}
