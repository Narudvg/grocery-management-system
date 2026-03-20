package com.example.OnlineGrocery.repository;

import com.example.OnlineGrocery.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem,Long> {
}
