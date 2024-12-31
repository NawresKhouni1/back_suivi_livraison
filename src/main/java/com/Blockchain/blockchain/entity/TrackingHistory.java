package com.Blockchain.blockchain.entity;

import java.time.LocalDateTime;

import com.Blockchain.blockchain.entity.Enums.DeliveryStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TrackingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Delivery delivery;

    private LocalDateTime timestamp;
    private String location;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Delivery getDelivery() {
        return delivery;
    }
    
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public DeliveryStatus getStatus() {
        return status;
    }
    
    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
    
}
