package com.example.controler;

import com.example.dto.LogInDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder pe;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LogInDto logInDto) {
        Authentication authenticate = AuthenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logInDto.getUsernameOrEmail(), logInDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);

        return ResponseEntity.status(HttpStatus.OK)
                .body("signIn successfully!");
    }
}
