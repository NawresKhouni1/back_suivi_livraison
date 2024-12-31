package com.Blockchain.blockchain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Blockchain.blockchain.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findById(Long id);

    Optional<Delivery> findByTrackNumber(String trackNumber);

}