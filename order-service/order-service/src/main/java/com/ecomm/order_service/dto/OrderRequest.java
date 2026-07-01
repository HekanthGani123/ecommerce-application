package com.ecomm.order_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {

    private Long userId;

    private BigDecimal totalAmount;

    private String status;
}
