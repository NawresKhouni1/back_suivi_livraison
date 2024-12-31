package com.Blockchain.blockchain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.Blockchain.blockchain.entity.Enums.DeliveryStatus;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String trackNumber;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;


    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private LocalDateTime actualArrivalDate;

    private String originAddress;
    private String destinationAddress;
    private String currentLocation;

    private Double weight;
    private Double price;

    @ManyToOne
    // @JsonManagedReference
    private Customer recipient;

    @ManyToOne
    // @JsonManagedReference 
    private Driver assignedDriver;
    // Constructors

    public Delivery() {}

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTrackNumber() {
        return trackNumber;
    }
    
    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }
    
    public DeliveryStatus getStatus() {
        return status;
    }
    
    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
    
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }
    
    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
    
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
    
    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public LocalDateTime getActualArrivalDate() {
        return actualArrivalDate;
    }
    
    public void setActualArrivalDate(LocalDateTime actualArrivalDate) {
        this.actualArrivalDate = actualArrivalDate;
    }
    
    public String getOriginAddress() {
        return originAddress;
    }
    
    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
    
    public String getDestinationAddress() {
        return destinationAddress;
    }
    
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
    
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public Double getWeight() {
        return weight;
    }
    
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Customer getRecipient() {
        return recipient;
    }
    
    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }
    
    public Driver getAssignedDriver() {
        return assignedDriver;
    }
    
    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }
    
}

 

 

   