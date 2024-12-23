package com.scrum.team.service;

import com.scrum.team.entity.Users;
import com.scrum.team.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepo userRepo;

    public Users saveUser(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
       return userRepo.save(users);
    }

    public String verify(Users users) {
        Authentication authentication =
                authManager
                        .authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(users.getUsername());
         else return "Failed..!";
    }
}