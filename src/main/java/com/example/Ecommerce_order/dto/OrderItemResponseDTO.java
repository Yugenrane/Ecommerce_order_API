package com.example.Ecommerce_order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemResponseDTO {
    private String orderTrackingNumber;
    private String razorpayPaymentId;
}
