package com.Blockchain.blockchain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blockchain.blockchain.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findById(Integer id);
    List<Driver> findByAvailability(Boolean availability);


}
