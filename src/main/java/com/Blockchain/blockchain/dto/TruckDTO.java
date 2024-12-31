package com.Blockchain.blockchain.dto;

import java.util.List;

import com.Blockchain.blockchain.entity.Enums.TruckStatus;
import com.Blockchain.blockchain.entity.Enums.TruckType;
import com.Blockchain.blockchain.entity.Truck;


public class TruckDTO {

    private Long id;
    private String truckNumber;
    private String type;  // Truck type as String
    private String licensePlate;
    private String status;  // Truck status as String

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Convert DTO to Entity
    public Truck toEntity() {
        Truck truck = new Truck();
        truck.setId(this.id);
        truck.setTruckNumber(this.truckNumber);
        truck.setLicensePlate(this.licensePlate);
        
        // Convert String status to TruckStatus Enum
        truck.setStatus(TruckStatus.valueOf(this.status.toUpperCase()));  // Convert to enum using toUpperCase for case insensitivity
        
        // Convert String type to TruckType Enum
        truck.setType(TruckType.valueOf(this.type.toUpperCase()));  // Convert to enum using toUpperCase

        return truck;
    }
}