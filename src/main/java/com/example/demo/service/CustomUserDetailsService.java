package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For now, this creates a mock user to allow the app to start
        // You can link this to your Database later
        if ("admin".equals(username)) {
            return new User("admin", "$2a$10$8K1p/a0dxreIFIsASzT6p.ES9mJ0vVclS6uLpG8A.v1YVv3mD3Hty", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
// mvn spring-boot:run -Dspring-boot.run.arguments=--debug