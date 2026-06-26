package com.ecomm.user_service.service;

import com.ecomm.user_service.dto.UserRequest;
import com.ecomm.user_service.entity.User;
import com.ecomm.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(UserRequest request){

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return repository.save(user);
    }
}
