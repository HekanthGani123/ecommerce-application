package com.ecomm.cart_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {

    private Long userId;

    private BigDecimal totalAmount;

    private String status;
}
