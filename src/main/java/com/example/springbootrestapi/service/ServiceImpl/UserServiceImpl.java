package com.example.springbootrestapi.service.ServiceImpl;

import com.example.springbootrestapi.Dto.UserRequestDTO;

import com.example.springbootrestapi.Dto.UserResponseDTO;
import com.example.springbootrestapi.entity.User;
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
        User user1 = new User();
        BeanUtils.copyProperties(userDTO, user1);
        return modelMapper.map(userRepository.save(user1), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserByID(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(user -> modelMapper.map(user,UserResponseDTO.class)).orElse(null);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> user1 = userRepository.findAll();
        return user1.stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).collect(Collectors.toList());
    }
}
