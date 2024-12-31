package com.Blockchain.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Blockchain.blockchain.entity.TrackingHistory;

@Repository
public interface TrackingHistoryRepository extends JpaRepository<TrackingHistory, Long> {
}
