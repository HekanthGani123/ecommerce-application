package com.ecomm.cart_service.service;

import com.ecomm.cart_service.dto.OrderRequest;
import com.ecomm.cart_service.dto.OrderResponse;
import com.ecomm.cart_service.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderClient {

    @Autowired
    private WebClient webClient;

    public OrderResponse placeOrder(OrderRequest request) {

        return webClient
                .post()
                .uri("http://localhost:8084/orders")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OrderResponse.class)
                .block();
    }
}
