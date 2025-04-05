package com.newssummarizer.authservice.controller;

import com.newssummarizer.authservice.dto.AuthResponse;
import com.newssummarizer.authservice.dto.RegisterRequest;
import com.newssummarizer.authservice.entity.User;
import com.newssummarizer.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.newssummarizer.authservice.dto.RegisterRequest;
import com.newssummarizer.authservice.dto.AuthResponse;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
   /* @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody User user){
        User createdUser = userService.registerUser(user);
        return ResponseEntity.ok(createdUser);
    }*/

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

}
