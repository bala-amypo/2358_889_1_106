package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {
    
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    
    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/register")
    @Operation(summary = "Register new user")
    public ResponseEntity<User> register(@RequestBody User user) {
        User created = userService.register(user);
        return ResponseEntity.ok(created);
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtTokenProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
            AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.badRequest().build();
    }
}