package com.example.springbootrestapi.Dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String firstName;
    private String lastName;
    private  String email;

}
