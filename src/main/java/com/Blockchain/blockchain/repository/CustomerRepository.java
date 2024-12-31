package com.Blockchain.blockchain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blockchain.blockchain.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
        Optional<Customer> findById(Integer id);

}
