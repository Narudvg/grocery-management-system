package com.example.OnlineGrocery.service;



import com.example.OnlineGrocery.entity.Customer;
import com.example.OnlineGrocery.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Tells Spring this is our business logic class
public class CustomerService {

    private final CustomerRepository customerRepository;

    // We inject the repository into the service via the constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CREATE / UPDATE
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // READ (All)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // READ (By ID)
    public Customer getCustomerById(Long id) {
        // If the customer isn't found, we throw an error.
        // We will turn this into a 404 Not Found error later!
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    // DELETE
    public void deleteCustomer(Long id) {
        // Check if they exist first
        Customer existingCustomer = getCustomerById(id);
        customerRepository.delete(existingCustomer);
    }
}