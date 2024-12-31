package com.Blockchain.blockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Blockchain.blockchain.entity.Customer;
import com.Blockchain.blockchain.repository.CustomerRepository;
import com.Blockchain.blockchain.service.CustomerService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/admin/api-customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add-customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
        // return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);

    }

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/get-customer-by-id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/edit-customer/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Integer id, @RequestBody Customer customerRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(customerRequest.getName());
            existingCustomer.setAddress(customerRequest.getAddress());
            existingCustomer.setPhone(customerRequest.getPhone());
            existingCustomer.setEmail(customerRequest.getEmail());

            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    
    }

}