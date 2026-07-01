package com.ecomm.cart_service.service;

import com.ecomm.cart_service.dto.CartRequest;
import com.ecomm.cart_service.entity.CartItem;
import com.ecomm.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public CartItem saveCart(CartRequest request) {
        CartItem item = new CartItem();
        item.setUserId(request.getUserId());
        item.setProductId(request.getProductId());
        item.setQuantity(request.getQuantity());
        repository.save(item);
        return item;
    }
}
