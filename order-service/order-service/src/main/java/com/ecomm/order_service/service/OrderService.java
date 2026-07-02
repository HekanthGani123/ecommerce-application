package com.ecomm.order_service.service;

import com.ecomm.order_service.dto.OrderRequest;
import com.ecomm.order_service.entity.Order;
import com.ecomm.order_service.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository repository;

    public Order saveOrder(OrderRequest request) {
        LOG.info("Order received from the Cart service: {} ", request);
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setStatus(request.getStatus());
        order.setTotalAmount(request.getTotalAmount());
        repository.save(order);
        return order;
    }


}
