package com.example.dto;

import lombok.Data;

@Data
public class LogInDto {

    private String usernameOrEmail;
    private String password;
}
