package com.openclassrooms.mddapi.dtos;

public class UserResponseDTO {

    private String username;
    private String email;
    // subscrptions

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
