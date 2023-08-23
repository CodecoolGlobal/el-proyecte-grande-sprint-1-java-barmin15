package com.codecool.eventPlanner;

import com.codecool.eventPlanner.config.ConfigureDatabase;
import com.codecool.eventPlanner.controller.AuthController;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventPlannerApplication {

	@Autowired
	ConfigureDatabase configureDatabase;


	public static void main(String[] args) {
		SpringApplication.run(EventPlannerApplication.class, args);
	}

	@PostConstruct
	public void seedDatabase() {
		configureDatabase.registerUsers();
	}

}
