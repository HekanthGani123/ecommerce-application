package com.ecomm.cart_service.service;

import com.ecomm.cart_service.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserClient {

    @Autowired
    private WebClient webClient;

    public UserResponse getUser(Long userId) {

        return webClient
                .get()
                .uri("http://localhost:8081/users/" + userId)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();

    }
}
