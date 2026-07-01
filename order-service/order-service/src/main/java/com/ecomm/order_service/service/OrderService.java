package com.ecomm.order_service.service;

import com.ecomm.order_service.dto.OrderRequest;
import com.ecomm.order_service.entity.Order;
import com.ecomm.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order saveOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setStatus(request.getStatus());
        order.setTotalAmount(request.getTotalAmount());

        repository.save(order);
        return order;
    }


}
