package com.example.OnlineGrocery.service;

import com.example.OnlineGrocery.entity.GroceryItem;
import com.example.OnlineGrocery.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    public GroceryItemService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public GroceryItem saveGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grocery Item not found with id: " + id));
    }

    public void deleteGroceryItem(Long id) {
        GroceryItem item = getGroceryItemById(id);
        groceryItemRepository.delete(item);
    }
}
