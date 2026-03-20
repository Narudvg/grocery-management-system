package com.example.OnlineGrocery.repository;

import com.example.OnlineGrocery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
