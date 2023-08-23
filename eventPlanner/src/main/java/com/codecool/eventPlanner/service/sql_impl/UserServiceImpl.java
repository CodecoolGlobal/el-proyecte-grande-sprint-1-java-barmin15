package com.codecool.eventPlanner.service.sql_impl;

import com.codecool.eventPlanner.exceptions.AppException;
import com.codecool.eventPlanner.model.dto.CredentialsDTO;
import com.codecool.eventPlanner.model.dto.SignUpDTO;
import com.codecool.eventPlanner.model.dto.UserDTO;
import com.codecool.eventPlanner.model.dto.user.LoginUserDTO;
import com.codecool.eventPlanner.model.dto.user.NewUserDTO;
import com.codecool.eventPlanner.model.dto.user.UpdateUserDTO;
import com.codecool.eventPlanner.model.entity.User;
import com.codecool.eventPlanner.repository.EventRepository;
import com.codecool.eventPlanner.repository.UserRepository;
import com.codecool.eventPlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private User currentUser;

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EventRepository eventRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

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
        return false;
    }

    @Override
    public boolean updateUser(UpdateUserDTO updateUserDTO) {
        return false;
    }

    @Override
    public boolean loginUser(LoginUserDTO loginUserDTO) {
        return false;
    }

  /*  @Override
    public boolean addUser(NewUserDTO newUserDTO) {
        User newUser = new User(newUserDTO);
        userRepository.save(newUser);
        currentUser = newUser;
        return true;
    }*/

    /*@Override
    public boolean updateUser(UpdateUserDTO updateUserDTO) {
        User user = userRepository.findById(updateUserDTO.id()).get();
        user.update(updateUserDTO);
        userRepository.save(user);
        return true;
    }*/

  /*  @Override
    public boolean loginUser(LoginUserDTO loginUserDTO) {
        String username = loginUserDTO.username();
        String password = loginUserDTO.password();
        currentUser = findUser(username, password);
        return getAllUsers().stream().anyMatch(user1 -> isValidUser(user1, username, password));
    }*/

    @Override
    public Set<User> getInterestedUsersByEventId(Long eventId) {
        return eventRepository.findById(eventId).get().getInterestedUsers();
    }

/*    private boolean isValidUser(User user, String username, String password) {
        return user.getName().equals(username) && user.getPassword().equals(password);
    }*/

    /*private User findUser(String username, String password) {
        return getAllUsers().stream().filter(user -> isValidUser(user, username, password)).findFirst().orElse(null);
    }*/

    @Override
    public UserDTO findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLogin(user.getLogin());
        userDTO.setLastName(user.getLastName());
        userDTO.setId(user.getId());
        return userDTO;
       /* return new UserDTO().setFirstName(user.getFirstName());
        return userMapper.toUserDTO(user);*/
    }

    @Override
    public UserDTO login(CredentialsDTO credentialDTO) {
        System.out.println("ide kerülok loginnál (userServiceImpl)");
        User user = userRepository.findByLogin(credentialDTO.getLogin())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialDTO.getPassword()), user.getPassword())) {

            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLogin(user.getLogin());
            userDTO.setLastName(user.getLastName());
            userDTO.setId(user.getId());
            return userDTO;
           // return userMapper.toUserDTO(user);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDTO register(SignUpDTO userDTO) {
        System.out.println("itt keresem, hogy van e ilyen user (userServiceImpl)");
        Optional<User> optionalUser = userRepository.findByLogin(userDTO.getLogin());

        if (optionalUser.isPresent()) {
            System.out.println("itt dobom ki, ha van ilyen user");
            throw new AppException("Already a user", HttpStatus.BAD_REQUEST);
        }
        User user = User.builder().lastName(userDTO.getLastName()).firstName(userDTO.getFirstName()).login(userDTO.getLogin()).build();

        System.out.println(user + "ez a user jelentkezett/regisztrált most be (userServiceImpl)");

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
        User savedUser = userRepository.save(user);


        UserDTO userDto = new UserDTO();
        userDto.setFirstName(user.getFirstName());
        userDto.setLogin(user.getLogin());
        userDto.setLastName(user.getLastName());
        userDto.setId(user.getId());
        return userDto;

    }
}









