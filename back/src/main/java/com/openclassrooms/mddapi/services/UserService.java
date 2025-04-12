package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dtos.LoginRequestDTO;
import com.openclassrooms.mddapi.dtos.TokenResponseDTO;
import com.openclassrooms.mddapi.dtos.UserRequestDTO;
import com.openclassrooms.mddapi.dtos.UserResponseDTO;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.UserMapper;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        Optional<User> existingUser = this.userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }
        // encrypt password when security installed and configured
        String password = passwordEncoder.encode(userDTO.getPassword());
        User user = userMapper.convertToEntity(userDTO, password);
        userRepository.save(user);
        return getUserByEmail(userDTO.getEmail());
    }

    public TokenResponseDTO verifyUser(LoginRequestDTO login) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        if (auth.isAuthenticated()) {
            String token = jwtService.generateToken(login.getEmail());
            TokenResponseDTO response = new TokenResponseDTO();
            response.setToken(token);
            return response;
        } else if (!auth.isAuthenticated()) {
            throw new RuntimeException("Incorrect username password combination");
        }
        throw new RuntimeException("Incorrect username password combination");
    }

    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.convertToResponseEntity(user);
    }
}
