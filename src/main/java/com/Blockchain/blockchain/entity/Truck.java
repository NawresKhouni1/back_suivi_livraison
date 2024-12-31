package com.Blockchain.blockchain.entity;

import java.util.List;

import com.Blockchain.blockchain.entity.Enums.TruckType;

import com.Blockchain.blockchain.entity.Enums.TruckStatus;

import jakarta.persistence.*;

@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String truckNumber;
    private TruckType type;
    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private TruckStatus status;

    // @OneToMany(mappedBy = "truck")
    // private List<Driver> drivers;

    // Constructors
    public Truck() {}

    public Truck(String truckNumber, TruckType type, String licensePlate) {
        this.truckNumber = truckNumber;
        this.type = type;
        this.licensePlate = licensePlate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public TruckType getType() {
        return type;
    }
    
    public void setType(TruckType type) {
        this.type = type;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getTruckNumber() {
        return truckNumber;
    }
    
    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }
    
    public TruckStatus getStatus() {
        return status;
    }
    
    public void setStatus(TruckStatus status) {
        this.status = status;
    }
    
    // public List<Driver> getDrivers() {
    //     return drivers;
    // }
    
    // public void setDrivers(List<Driver> drivers) {
    //     this.drivers = drivers;
    // }
}    