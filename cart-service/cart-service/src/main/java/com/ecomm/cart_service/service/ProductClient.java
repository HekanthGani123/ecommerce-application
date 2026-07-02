package com.ecomm.cart_service.service;

import com.ecomm.cart_service.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductClient {

    @Autowired
    private WebClient webClient;

    public ProductResponse getProduct(Long productId){

        return webClient
                .get()
                .uri("http://localhost:8082/products/" + productId)
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .block();

    }

}
