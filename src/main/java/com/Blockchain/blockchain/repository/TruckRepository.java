package com.Blockchain.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blockchain.blockchain.entity.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}