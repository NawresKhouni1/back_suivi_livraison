package com.Blockchain.blockchain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blockchain.blockchain.Exception.ResourceNotFoundException;
import com.Blockchain.blockchain.entity.Customer;
import com.Blockchain.blockchain.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
     public Customer updateCustomr(Long customerId, Customer customerDetails) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
        customer.setName(customerDetails.getName());
        customer.setAddress(customerDetails.getAddress());
        customer.setPhone(customerDetails.getPhone());
        customer.setEmail(customerDetails.getEmail());
        return customerRepository.save(customer);
    }
    
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}