package com.Blockchain.blockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Blockchain.blockchain.dto.TruckDTO;
import com.Blockchain.blockchain.entity.Truck;
import com.Blockchain.blockchain.service.TruckService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/admin/api-trucks")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping("/get-all-trucks")
    public List<Truck> getAllTrucks() {
        return truckService.getAllTrucks();  // Get all trucks
    }

    @PostMapping("/add-truck")
    public Truck addTruck(@RequestBody TruckDTO truckDTO) {
        // Convert DTO to Entity
        Truck truck = truckDTO.toEntity();
        return truckService.addTruck(truck);  // Call service to save the truck
    }
}