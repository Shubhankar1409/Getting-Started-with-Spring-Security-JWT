package com.practicejwt.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicejwt.security.entity.User;
import com.practicejwt.security.repository.UserRepository;
import com.practicejwt.security.service.UserService;

@RestController
public class UserController {

    private final UserRepository userRepository;

    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        //return userRepository.save(user);
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }

}
