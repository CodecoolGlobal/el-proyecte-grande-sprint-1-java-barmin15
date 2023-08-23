package com.codecool.eventPlanner.controller;

import com.codecool.eventPlanner.config.UserAuthProvider;
import com.codecool.eventPlanner.model.dto.CredentialsDTO;
import com.codecool.eventPlanner.model.dto.SignUpDTO;
import com.codecool.eventPlanner.model.dto.UserDTO;
import com.codecool.eventPlanner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    private final UserAuthProvider userAuthProvider;


    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody CredentialsDTO credentialsDTO) {
        System.out.println("itt loginolni akarok");
        UserDTO user = userService.login(credentialsDTO);

        user.setToken(userAuthProvider.createToken(user.getLogin()));

        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody SignUpDTO signUpDTO) {
        System.out.println("itt bejut a fetch az endpointra (AuthController)");

        UserDTO user = userService.register(signUpDTO);
        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.created(URI.create("/users/" + user.getId()))
                .body(user);
    }

}
