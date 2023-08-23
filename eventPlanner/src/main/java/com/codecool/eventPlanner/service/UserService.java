package com.codecool.eventPlanner.service;

import com.codecool.eventPlanner.model.dto.CredentialsDTO;
import com.codecool.eventPlanner.model.dto.SignUpDTO;
import com.codecool.eventPlanner.model.dto.UserDTO;
import com.codecool.eventPlanner.model.dto.user.LoginUserDTO;
import com.codecool.eventPlanner.model.dto.user.NewUserDTO;
import com.codecool.eventPlanner.model.dto.user.UpdateUserDTO;
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

    boolean addUser(NewUserDTO newUserDTO);

    boolean updateUser(UpdateUserDTO updateUserDTO);

    boolean loginUser(LoginUserDTO loginUserDTO);

    Set<User> getInterestedUsersByEventId(Long eventId);

    UserDTO findByLogin(String issuer);

    UserDTO register(SignUpDTO userDTO);
    UserDTO login(CredentialsDTO credentialDTO);
}
