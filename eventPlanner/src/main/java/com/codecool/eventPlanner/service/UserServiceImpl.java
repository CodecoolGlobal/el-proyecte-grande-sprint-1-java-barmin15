package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.dto.NewUserDTO;
import com.codecool.eventPlanner.model.entity.Event;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    private User currentUser;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
//        String userName = newUserDTO.username();
//        String password = newUserDTO.password();
//        String registrationDate = newUserDTO.registrationDate();
//        User newUser = new User(userName, password, registrationDate, registrationDate, new HashSet<>(), new HashSet<>());
        User newUser = new User(newUserDTO);
        userRepository.save(newUser);
        System.out.println("user saved :-)");
        return true;
    }
}









