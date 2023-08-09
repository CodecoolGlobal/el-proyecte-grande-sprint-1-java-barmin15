package com.codecool.eventPlanner.service.sql_impl;

import com.codecool.eventPlanner.model.dto.LoginUserDTO;
import com.codecool.eventPlanner.model.dto.NewUserDTO;
import com.codecool.eventPlanner.model.dto.UpdateUserDTO;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.repository.EventRepository;
import com.codecool.eventPlanner.repository.UserRepository;
import com.codecool.eventPlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private User currentUser;

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        System.out.println(id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsersByEvent(Long eventId) {
        //return userRepository.getUsersByEvent(eventId);
        return null;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean addUser(NewUserDTO newUserDTO) {
        User newUser = new User(newUserDTO);
        userRepository.save(newUser);
        currentUser = newUser;
        return true;
    }

    @Override
    public boolean updateUser(UpdateUserDTO updateUserDTO) {
        User user = userRepository.findById(updateUserDTO.id()).get();
        user.update(updateUserDTO);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean loginUser(LoginUserDTO loginUserDTO) {
        String username = loginUserDTO.username();
        String password = loginUserDTO.password();
        currentUser = findUser(username, password);
        return getAllUsers().stream().anyMatch(user1 -> isValidUser(user1, username, password));
    }

    @Override
    public Set<User> getInterestedUsersByEventId(Long eventId) {
        return eventRepository.findById(eventId).get().getInterestedUsers();
    }

    private boolean isValidUser(User user, String username, String password) {
        return user.getName().equals(username) && user.getPassword().equals(password);
    }
    private User findUser(String username, String password) {
      return getAllUsers().stream().filter(user -> isValidUser(user, username, password)).findFirst().orElse(null);
    }
}









