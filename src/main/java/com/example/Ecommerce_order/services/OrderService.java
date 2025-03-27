package com.example.Ecommerce_order.services;

import com.example.Ecommerce_order.dto.OrderItemResponseDTO;
import com.example.Ecommerce_order.dto.OrderRequestDTO;
import com.example.Ecommerce_order.entities.Customer;
import com.example.Ecommerce_order.entities.Orders;
import com.example.Ecommerce_order.entities.ShippingAddress;
import com.example.Ecommerce_order.repositories.CustomerRepo;
import com.example.Ecommerce_order.repositories.OrderRepo;

import com.example.Ecommerce_order.repositories.ShippingAddressRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final ShippingAddressRepo shippingAddressRepo;
    public OrderService(OrderRepo orderRepo, CustomerRepo customerRepo, ShippingAddressRepo shippingAddressRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.shippingAddressRepo=shippingAddressRepo;
    }

    public OrderItemResponseDTO placeOrder(OrderRequestDTO orderRequest){
        Customer customer=customerRepo.findByCustomerEmail(orderRequest.getCustomerEmail()).orElseGet(() -> {
            Customer newCustomer=new Customer();
            newCustomer.setCustomerName(orderRequest.getCustomerName());
            newCustomer.setCustomerEmail(orderRequest.getCustomerEmail());
            newCustomer.setCustomerPassword(UUID.randomUUID().toString());
            newCustomer.setCustomerPhoneNo(orderRequest.getCustomerPhone());
            return customerRepo.save(newCustomer);
        });
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setStreet(orderRequest.getShippingAddressDTO().getStreet());
        shippingAddress.setCity(orderRequest.getShippingAddressDTO().getCity());
        shippingAddress.setState(orderRequest.getShippingAddressDTO().getState());
        shippingAddress.setZipcode(orderRequest.getShippingAddressDTO().getZipcode());
        shippingAddress.setCountry(orderRequest.getShippingAddressDTO().getCountry());
        shippingAddressRepo.save(shippingAddress);
        Orders order=new Orders();
        order.setCustomer(customer);
        order.setAddress(shippingAddress);
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        order.setTotalQuantity(orderRequest.getOrderItems().size());
        order.setTotalPrice(orderRequest.getTotalPrice());
        orderRepo.save(order);

        order.setRazorpayId(UUID.randomUUID().toString());
        
        return new OrderItemResponseDTO(order.getOrderTrackingNumber(), order.getRazorpayId());
    }
}
