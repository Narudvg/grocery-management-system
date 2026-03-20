package com.example.OnlineGrocery.controller;


import com.example.OnlineGrocery.entity.GroceryItem;
import com.example.OnlineGrocery.service.GroceryItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class GroceryItemController {

    private final GroceryItemService groceryItemService;

    public GroceryItemController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @PostMapping
    public ResponseEntity<GroceryItem> createItem(@RequestBody GroceryItem item) {
        return new ResponseEntity<>(groceryItemService.saveGroceryItem(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return new ResponseEntity<>(groceryItemService.getAllGroceryItems(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(groceryItemService.getGroceryItemById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}