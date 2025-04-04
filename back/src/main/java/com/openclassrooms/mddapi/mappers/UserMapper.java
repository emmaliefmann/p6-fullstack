package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.UserRequestDTO;
import com.openclassrooms.mddapi.dtos.UserResponseDTO;
import com.openclassrooms.mddapi.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User convertToEntity(UserRequestDTO request, String password) {
        User user = modelMapper.map(request, User.class);
        user.setPassword(password);
        user.setCreated_at(LocalDateTime.now());
        return user;
    }

    public UserResponseDTO convertToResponseEntity(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }
}
