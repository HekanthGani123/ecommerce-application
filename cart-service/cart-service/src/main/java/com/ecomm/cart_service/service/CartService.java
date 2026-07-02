package com.ecomm.cart_service.service;

import com.ecomm.cart_service.dto.*;
import com.ecomm.cart_service.entity.CartItem;
import com.ecomm.cart_service.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {

    private static final Logger LOG = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartRepository repository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderClient orderClient;

    public CartItem saveCart(CartRequest request) {

        // communicate to User-service to know user details
        UserResponse user = userClient.getUser(request.getUserId());

        // communicate to Product-service to know product details
        ProductResponse product = productClient.getProduct(request.getProductId());
        BigDecimal price = product.getPrice();
        Integer quantity = request.getQuantity();
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(quantity));

        // based on the above details create a Order request
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setUserId(user.getId());
        orderRequest.setTotalAmount(totalPrice);
        orderRequest.setStatus("CREATED");

        // communicate to Order service to place the order
        OrderResponse orderResponse = orderClient.placeOrder(orderRequest);
        LOG.info("Order Placed Successfully:{} ", orderResponse);

        CartItem item = new CartItem();
        item.setUserId(request.getUserId());
        item.setProductId(request.getProductId());
        item.setQuantity(request.getQuantity());
        repository.save(item);
        return item;
    }
}
