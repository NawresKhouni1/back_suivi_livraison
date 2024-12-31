package com.Blockchain.blockchain.dto;

import java.time.LocalDateTime;

import com.Blockchain.blockchain.entity.Delivery;

public class DeliveryDTO {

    private Long id;
    private String trackNumber;
    private String status; // Keep it as String
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private LocalDateTime actualArrivalDate;
    private String originAddress;
    private String destinationAddress;
    private String currentLocation;
    private Double weight;
    private Double price;
    private Long recipientId;
    private Long driverId;

    // Constructors
    public DeliveryDTO() {}

    public DeliveryDTO(Delivery delivery) {
        this.id = delivery.getId();
        this.trackNumber = delivery.getTrackNumber();
        this.status = delivery.getStatus() != null ? delivery.getStatus().name() : null; // Convert enum to String
        this.departureDate = delivery.getDepartureDate();
        this.arrivalDate = delivery.getArrivalDate();
        this.actualArrivalDate = delivery.getActualArrivalDate();
        this.originAddress = delivery.getOriginAddress();
        this.destinationAddress = delivery.getDestinationAddress();
        this.currentLocation = delivery.getCurrentLocation();
        this.weight = delivery.getWeight();
        this.price = delivery.getPrice();
        // this.recipientId = delivery.getRecipient() != null ? delivery.getRecipient().getId() : null;
        // this.driverId = delivery.getAssignedDriver() != null ? delivery.getAssignedDriver().getId() : null;
    }
    // Getters and setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    // public Long getRecipientId() {
    //     return recipientId;
    // }

    // public void setRecipientId(Long recipientId) {
    //     this.recipientId = recipientId;
    // }

    // public Long getDriverId() {
    //     return driverId;
    // }

    // public void setDriverId(Long driverId) {
    //     this.driverId = driverId;
    // }

    
}