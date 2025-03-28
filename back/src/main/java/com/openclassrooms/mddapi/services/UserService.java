package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.UserRequestDTO;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequestDTO userDTO) {
        Optional<User> existingUser = this.userRepository.findByEmail(userDTO.getEmail());

        // encrypt password

    }
}
