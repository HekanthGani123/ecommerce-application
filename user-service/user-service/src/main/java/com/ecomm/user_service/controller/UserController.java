package com.ecomm.user_service.controller;

import com.ecomm.user_service.dto.UserRequest;
import com.ecomm.user_service.entity.User;
import com.ecomm.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User createUser(@RequestBody UserRequest request) {
        return service.createUser(request);
    }
}
