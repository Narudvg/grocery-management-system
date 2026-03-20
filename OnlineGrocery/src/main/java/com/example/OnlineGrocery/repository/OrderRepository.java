package com.example.OnlineGrocery.repository;

import com.example.OnlineGrocery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
