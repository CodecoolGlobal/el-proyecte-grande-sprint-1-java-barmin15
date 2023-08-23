package com.codecool.eventPlanner.config;

import com.codecool.eventPlanner.controller.AuthController;
import com.codecool.eventPlanner.model.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConfigureDatabase {


    private AuthController authController;
    @Autowired
    public ConfigureDatabase(AuthController authController1){
        this.authController = authController1;
    }

    public void registerUsers() {
        String password = "titok";
        char[] charPassword = password.toCharArray();
        SignUpDTO armin = SignUpDTO.builder().firstName("armin").lastName("armin").login("armin").password(charPassword).build();
        SignUpDTO laci = SignUpDTO.builder().firstName("laci").lastName("laci").login("laci").password(charPassword).build();
        SignUpDTO anna = SignUpDTO.builder().firstName("anna").lastName("anna").login("anna").password(charPassword).build();

        List<SignUpDTO> people = List.of(anna,armin,laci);

        people.forEach(person -> {
            authController.register(person);
        });
    }
}
