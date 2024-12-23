package com.scrum.team.controller;

import com.scrum.team.entity.Users;
import com.scrum.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Users register(@RequestBody Users users)
    {
        return userService.saveUser(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users)
    {
         return userService.verify(users);
    }
}
