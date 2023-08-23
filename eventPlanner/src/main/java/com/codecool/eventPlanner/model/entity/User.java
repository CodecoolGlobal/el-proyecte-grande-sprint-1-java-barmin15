package com.codecool.eventPlanner.model.entity;

import com.codecool.eventPlanner.model.dto.user.NewUserDTO;
import com.codecool.eventPlanner.model.dto.user.UpdateUserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CookieValue;

import java.util.Optional;
import java.util.Set;

@Entity(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "creator")
    @JsonManagedReference
    private Set<Event> createdEvents;

    @ManyToMany(mappedBy = "interestedUsers")
    @JsonManagedReference
    private Set<Event> interestedEvents;

   /* public User(NewUserDTO newUserDTO) {
        name = newUserDTO.username();
        password = newUserDTO.password();
        lastOnline = newUserDTO.registrationDate();
        registrationDate = newUserDTO.registrationDate();
    }

    public void update(UpdateUserDTO updateUserDTO) {
        this.name = Optional.ofNullable(updateUserDTO.name()).orElse(this.name);
        this.password = Optional.ofNullable(updateUserDTO.password()).orElse(this.password);
        this.description = Optional.ofNullable(updateUserDTO.description()).orElse(this.description);
    }*/
}
