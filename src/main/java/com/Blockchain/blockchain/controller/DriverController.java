package com.Blockchain.blockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Blockchain.blockchain.dto.DriverDTO;
import com.Blockchain.blockchain.entity.Delivery;
import com.Blockchain.blockchain.entity.Driver;
import com.Blockchain.blockchain.service.DriverService;

import java.util.*;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/admin/api-drivers")
public class DriverController {

    private final DriverService driverService;
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    // @Autowired
    // private DriverService driverService;

    // @Autowired
    // private DriverRepository driverRepository;
    // @GetMapping("/get-all-drivers")
    // public List<Driver> getAllDrivers() {
    //     return driverService.getAllDrivers();
    // }

    // @PostMapping("/add-driver")
    // public Driver createDriver(@RequestBody Driver driver) {
    //     return driverService.createDriver(driver);
    // }
//     @PostMapping("/add-driver")
//     public Driver addDriver(@RequestBody DriverDTO driverDTO) {
//         Driver driver = driverDTO.toEntity();
//         return driverService.createDriver(driver);
//     }

//     @GetMapping("/get-driver-by-id/{id}")
//     public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
//         return ResponseEntity.ok(driverService.getDriverById(id));
//     }

//     @PutMapping("/edit-driver/{id}")
//     public ResponseEntity<Driver> editDriver(@PathVariable Integer id, @RequestBody Driver driverRequest) {
//         Optional<Driver> driverOptional = driverRepository.findById(id);
//         if (driverOptional.isPresent()) {
//             Driver existingDriver = driverOptional.get();
//             existingDriver.setName(driverRequest.getName());
//             existingDriver.setLicenseNumber(driverRequest.getLicenseNumber());
//             existingDriver.setPhone(driverRequest.getPhone());
            
//             Driver updatedDriver = driverRepository.save(existingDriver);
//             return ResponseEntity.ok(updatedDriver);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/delete-driver/{id}")
//     public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
//         driverService.deleteDriver(id);
//         return ResponseEntity.noContent().build();
    
//     }

// }
// Get all drivers
@GetMapping("/get-all-drivers")
public List<DriverDTO> getAllDrivers() {
    return driverService.getAllDrivers()
            .stream()
            .map(this::convertToDTO)
            .toList();
}

// Get driver by ID
@GetMapping("/get-driver-by-id/{id}")
public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id) {
    Optional<Driver> driver = driverService.getDriverById(id);
    return driver.map(value -> new ResponseEntity<>(convertToDTO(value), HttpStatus.OK))
                 .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

// Create a new driver
@PostMapping("/add-driver")
public ResponseEntity<DriverDTO> createDriver(@RequestBody DriverDTO driverDTO) {
    Driver savedDriver = driverService.saveDriver(driverDTO);
    return new ResponseEntity<>(convertToDTO(savedDriver), HttpStatus.CREATED);
}

// Delete driver
@DeleteMapping("/delete-driver/{id}")
public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
    driverService.deleteDriver(id);
    return ResponseEntity.noContent().build();
}

// Helper methods to convert between Driver and DriverDTO
private DriverDTO convertToDTO(Driver driver) {
    DriverDTO driverDTO = new DriverDTO();
    driverDTO.setId(driver.getId());
    driverDTO.setName(driver.getName());
    driverDTO.setLicenseNumber(driver.getLicenseNumber());
    driverDTO.setPhone(driver.getPhone());
    driverDTO.setAvailability(driver.getAvailability());
    if (driver.getVehicle() != null) {
        driverDTO.setTruckId(driver.getVehicle().getId());
    }
    // if (driver.getDeliveries() != null) {
    //         driverDTO.setDeliveryIds(driver.getDeliveries().stream()
    //             .map(Delivery::getId)
    //             .collect(Collectors.toList()));
    //     }
    return driverDTO;
}


}