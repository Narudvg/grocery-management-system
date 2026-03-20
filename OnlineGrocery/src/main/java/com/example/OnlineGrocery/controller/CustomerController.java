package com.example.OnlineGrocery.controller;


import com.example.OnlineGrocery.entity.Customer;
import com.example.OnlineGrocery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring this class handles web requests and returns JSON
@RequestMapping("/api/customers") // The base URL for all endpoints in this class
public class CustomerController {

    private final CustomerService customerService;

    // Inject the service
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // CREATE: POST request to /api/customers
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        // @RequestBody takes the JSON sent by the user and turns it into a Customer object
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED); // Returns 201 Created
    }

    // READ ALL: GET request to /api/customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK); // Returns 200 OK
    }

    // READ ONE: GET request to /api/customers/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        // @PathVariable grabs the {id} from the URL
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    // DELETE: DELETE request to /api/customers/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Returns 204 No Content (successful delete)
    }
}