package com.codecool.eventPlanner.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignUpDTO {
    private String firstName;
    private String lastName;
    private String login;
    private char[] password;
}
