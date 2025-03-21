package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<UserRequestDTO> registerUser(@RequestBody UserRequestDTO user) {

    }
}
