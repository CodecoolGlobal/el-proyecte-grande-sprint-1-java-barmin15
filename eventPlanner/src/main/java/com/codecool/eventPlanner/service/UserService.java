package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.dto.auth.CredentialsDTO;
import com.codecool.eventPlanner.model.dto.user.SignUpDTO;
import com.codecool.eventPlanner.model.dto.user.UserDTO;
import com.codecool.eventPlanner.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> getUsersByEvent(Long eventId);

    User getCurrentUser();

    Set<User> getInterestedUsersByEventId(Long eventId);

    UserDTO findByLogin(String issuer);

    UserDTO register(SignUpDTO userDTO);
    UserDTO login(CredentialsDTO credentialDTO);
}
