package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dtos.UserRequestDTO;
import com.openclassrooms.mddapi.dtos.UserResponseDTO;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.UserMapper;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        Optional<User> existingUser = this.userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }
        // encrypt password when security installed and configured
        User user = userMapper.convertToEntity(userDTO);
        userRepository.save(user);
        return getUserByEmail(userDTO.getEmail());
    }

    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.convertToResponseEntity(user);
    }
}
