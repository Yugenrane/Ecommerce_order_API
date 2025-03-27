package com.example.Ecommerce_order.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO {
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private BigDecimal totalPrice;
    private ShippingAddressDTO shippingAddressDTO;
    private List<OrderItemDTO> orderItems;
}
