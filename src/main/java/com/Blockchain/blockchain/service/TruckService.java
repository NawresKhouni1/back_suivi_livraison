package com.Blockchain.blockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Blockchain.blockchain.entity.Truck;
import com.Blockchain.blockchain.repository.DriverRepository;
import com.Blockchain.blockchain.repository.TruckRepository;

import java.util.List;

@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

  
//     public List<Truck> getAllTrucks() {
//         return truckRepository.findAll();
//     }

//     public Truck createTruck(Truck truck) {
//         return truckRepository.save(truck);
//     }
// }
public Truck addTruck(Truck truck) {
    return truckRepository.save(truck);  // Save the truck to the database
}

public List<Truck> getAllTrucks() {
    return truckRepository.findAll();  // Get all trucks
}
}