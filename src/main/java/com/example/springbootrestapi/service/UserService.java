package com.example.springbootrestapi.service;

import com.example.springbootrestapi.Dto.UserRequestDTO;
import com.example.springbootrestapi.Dto.UserResponseDTO;
import com.example.springbootrestapi.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDTO CreateUser(UserRequestDTO user);
    UserResponseDTO getUserByID(Long userId);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(UserRequestDTO user);

    void deleteUser(Long userId);
}
