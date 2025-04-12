package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.*;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO user) {
        UserResponseDTO registered = userService.createUser(user);
        return ResponseEntity.ok().body(registered);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO login) {
        System.out.println("controller");
        TokenResponseDTO token = userService.verifyUser(login);
        System.out.println(token.getToken());
        return ResponseEntity.ok().body(token);
    }
}
