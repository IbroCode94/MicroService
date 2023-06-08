package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.Dto.UserRequestDTO;
import com.example.springbootrestapi.Dto.UserResponseDTO;
import com.example.springbootrestapi.entity.User;
import com.example.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> creatUser(@RequestBody UserRequestDTO userDTO){
        UserResponseDTO savedUser = userService.CreateUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") Long userId){
        UserResponseDTO user = userService.getUserByID(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity <List<UserResponseDTO>> getAllUsers(){
       List<UserResponseDTO> users= userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
