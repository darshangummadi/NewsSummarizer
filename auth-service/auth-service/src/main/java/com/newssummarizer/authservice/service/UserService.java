package com.newssummarizer.authservice.service;

import com.newssummarizer.authservice.dto.RegisterRequest;
import com.newssummarizer.authservice.dto.AuthResponse;


import com.newssummarizer.authservice.entity.User;
public interface UserService {
    User registerUser(User user);
    User getUserByUsername(String username);
    AuthResponse register(RegisterRequest request);

}
