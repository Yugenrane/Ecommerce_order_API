package com.example.Ecommerce_order.controllers;

import com.example.Ecommerce_order.dto.OrderItemResponseDTO;
import com.example.Ecommerce_order.dto.OrderRequestDTO;
import com.example.Ecommerce_order.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderItemResponseDTO> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        OrderItemResponseDTO orderItemResponseDTO=orderService.placeOrder(orderRequestDTO);
        return ResponseEntity.ok(orderItemResponseDTO);
    }
}
