package com.newssummarizer.authservice.service.impl;
import com.newssummarizer.authservice.entity.User;
import com.newssummarizer.authservice.repository.UserRepository;
import com.newssummarizer.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.newssummarizer.authservice.dto.RegisterRequest;
import com.newssummarizer.authservice.dto.AuthResponse;
import com.newssummarizer.authservice.config.JwtService;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /*@Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return AuthResponse.builder().message("Username already exists").build();
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            return AuthResponse.builder().message("Email already exists").build();
        }

        User newUser = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(newUser);

        return AuthResponse.builder()
                .message("User registered successfully")
                .build();
    }*/
    // jwt service
    @Autowired
    private JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        userRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse("User registered successfully", token);
    }

}
