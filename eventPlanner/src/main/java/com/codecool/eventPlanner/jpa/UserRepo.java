package com.codecool.eventPlanner.jpa;

import com.codecool.eventPlanner.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
