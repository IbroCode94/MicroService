package com.example.springbootrestapi.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private Long Id;
    @NotEmpty(message = "User first name should not be empty")
    private String firstName;
    @NotEmpty(message = "User last name should not be empty")
    private String lastName;
    @NotEmpty(message = "User email should not be empty")
    @Email(message = "User email address should be valid")
    private String email;
    private String password;
}
