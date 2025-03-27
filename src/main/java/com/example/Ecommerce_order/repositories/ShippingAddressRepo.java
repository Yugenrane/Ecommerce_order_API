package com.example.Ecommerce_order.repositories;

import com.example.Ecommerce_order.entities.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepo extends JpaRepository<ShippingAddress, Long> {
}
