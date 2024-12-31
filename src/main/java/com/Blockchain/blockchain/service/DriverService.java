package com.Blockchain.blockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blockchain.blockchain.dto.DriverDTO;
import com.Blockchain.blockchain.entity.Delivery;
import com.Blockchain.blockchain.entity.Driver;
import com.Blockchain.blockchain.entity.Truck;
import com.Blockchain.blockchain.repository.DeliveryRepository;
import com.Blockchain.blockchain.repository.DriverRepository;
import com.Blockchain.blockchain.repository.TruckRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverService {
      private final DriverRepository driverRepository;
    private final TruckRepository truckRepository;
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository, TruckRepository truckRepository, DeliveryRepository deliveryRepository) {
        this.driverRepository = driverRepository;
        this.truckRepository = truckRepository;
        this.deliveryRepository = deliveryRepository;
    }

   

// Get all drivers
public List<Driver> getAllDrivers() {
    return driverRepository.findAll();
}

// Get a single driver by ID
public Optional<Driver> getDriverById(Long id) {
    return driverRepository.findById(id);
}

// Save a driver
public Driver saveDriver(DriverDTO driverDTO) {
    Driver driver = new Driver();
    driver.setName(driverDTO.getName());
    driver.setLicenseNumber(driverDTO.getLicenseNumber());
    driver.setPhone(driverDTO.getPhone());
    driver.setAvailability(driverDTO.getAvailability());

    // Link to Truck
    if (driverDTO.getTruckId() != null) {
        Truck truck = truckRepository.findById(driverDTO.getTruckId())
            .orElseThrow(() -> new RuntimeException("Truck not found"));
        driver.setVehicle(truck);
    }

    //  // Link to Deliveries
    //     if (driverDTO.getDeliveryIds() != null) {
    //         List<Delivery> deliveries = driverDTO.getDeliveryIds().stream()
    //             .map(id -> deliveryRepository.findById(id)
    //                 .orElseThrow(() -> new RuntimeException("Delivery not found: " + id)))
    //             .collect(Collectors.toList());
    //         driver.setDeliveries(deliveries);
    //     }

    return driverRepository.save(driver);
}

// Delete a driver by ID
public void deleteDriver(Long id) {
    driverRepository.deleteById(id);
}
}