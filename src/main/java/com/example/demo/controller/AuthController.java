package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.securiy.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService) {
        this.userService = userService;
        this.jwtTokenProvider = new JwtTokenProvider(
                "VerySecretKeyForJWTsChangeMe1234567890",
                3600000
        );
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String roleStr = request.getOrDefault("role", "USER");

        Role role = Role.valueOf(roleStr.toUpperCase()); // ✅ FIXED

        String token = jwtTokenProvider.generateToken(1L, email, role);

        return ResponseEntity.ok(Map.of("token", token));
    }
}
