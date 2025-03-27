package com.example.Ecommerce_order.dto;

import lombok.Data;

@Data
public class ShippingAddressDTO {
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
