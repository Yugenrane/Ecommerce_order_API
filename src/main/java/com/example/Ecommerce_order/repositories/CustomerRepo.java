package com.example.Ecommerce_order.repositories;

import com.example.Ecommerce_order.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerEmail(String email);
}
