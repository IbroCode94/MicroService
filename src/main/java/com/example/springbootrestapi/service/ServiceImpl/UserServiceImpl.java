package com.example.springbootrestapi.service.ServiceImpl;

import com.example.springbootrestapi.Dto.UserRequestDTO;

import com.example.springbootrestapi.Dto.UserResponseDTO;
import com.example.springbootrestapi.entity.User;
import com.example.springbootrestapi.exception.EmailAlreadyExistsException;
import com.example.springbootrestapi.exception.ResourceNotFoundException;
import com.example.springbootrestapi.repository.UserRepository;
import com.example.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserResponseDTO CreateUser(UserRequestDTO userDTO) {
        Optional<User> optional = userRepository.findByEmail(userDTO.getEmail());
        if(optional.isPresent()){
            throw   new EmailAlreadyExistsException("Email Already Exist for this User");
        }
        User user1 = new User();
        BeanUtils.copyProperties(userDTO, user1);
        return modelMapper.map(userRepository.save(user1), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserByID(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> user1 = userRepository.findAll();
        return user1.stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO user) {
        User  existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
        BeanUtils.copyProperties(user, existingUser);
        User updatedUser =  userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);
    }
}
