package com.example.Ecommerce_order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    private Long productId;
    private String imgUrl;
    private BigDecimal unitPrice;
    private Integer quantity;
}
