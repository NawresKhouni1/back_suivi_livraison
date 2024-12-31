package com.Blockchain.blockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blockchain.blockchain.dto.DeliveryDTO;
import com.Blockchain.blockchain.entity.Delivery;
import com.Blockchain.blockchain.entity.Enums.DeliveryStatus;
import com.Blockchain.blockchain.repository.CustomerRepository;
import com.Blockchain.blockchain.repository.DeliveryRepository;
import com.Blockchain.blockchain.repository.DriverRepository;

import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Save or update a delivery
    public DeliveryDTO saveDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        
        // If the DTO has an existing ID, find and update the existing entity
        if (deliveryDTO.getId() != null) {
            delivery = deliveryRepository.findById(deliveryDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Delivery not found"));
        }

        // Set fields from DTO to Entity
        delivery.setTrackNumber(deliveryDTO.getTrackNumber());

        // Convert String status to DeliveryStatus enum
        if (deliveryDTO.getStatus() != null) {
            try {
                DeliveryStatus status = DeliveryStatus.valueOf(deliveryDTO.getStatus().toUpperCase());
                delivery.setStatus(status);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid status value");
            }
        }

        delivery.setDepartureDate(deliveryDTO.getDepartureDate());
        delivery.setArrivalDate(deliveryDTO.getArrivalDate());
        delivery.setActualArrivalDate(deliveryDTO.getActualArrivalDate());
        delivery.setOriginAddress(deliveryDTO.getOriginAddress());
        delivery.setDestinationAddress(deliveryDTO.getDestinationAddress());
        delivery.setCurrentLocation(deliveryDTO.getCurrentLocation());
        delivery.setWeight(deliveryDTO.getWeight());
        delivery.setPrice(deliveryDTO.getPrice());

        // Set Customer (Recipient)
        // if (deliveryDTO.getRecipientId() != null) {
        //     delivery.setRecipient(customerRepository.findById(deliveryDTO.getRecipientId())
        //             .orElseThrow(() -> new RuntimeException("Customer not found")));
        // }

        // // Set Driver (Assigned Driver)
        // if (deliveryDTO.getDriverId() != null) {
        //     delivery.setAssignedDriver(driverRepository.findById(deliveryDTO.getDriverId())
        //             .orElseThrow(() -> new RuntimeException("Driver not found")));
        // }

        // Save delivery entity
        Delivery savedDelivery = deliveryRepository.save(delivery);

        // Return the saved entity as a DTO
        return new DeliveryDTO(savedDelivery);
    }

    // Retrieve all deliveries
    public List<DeliveryDTO> getAllDeliveries() {
        return deliveryRepository.findAll().stream()
                .map(DeliveryDTO::new) // Convert entity to DTO
                .toList();
    }

    // Retrieve a specific delivery by ID
    public DeliveryDTO getDeliveryById(Long id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        return new DeliveryDTO(delivery);
    }
}
//     public List<Delivery> getAllDeliveries() {
//         return deliveryRepository.findAll();
//     }

//     public Optional<Delivery> getDeliveryById(Long id) {
//         return deliveryRepository.findById(id);
//     }

//      public Delivery createDelivery(Delivery delivery) {
//         delivery.setTrackNumber(UUID.randomUUID().toString());
//         // delivery.setStatus(DeliveryStatus.EN_COURS);
//         return deliveryRepository.save(delivery);
 
//     }

//     public Optional<Delivery> findDeliveryByTrackingNumber(String trackingNumber) {
//         return deliveryRepository.findByTrackNumber(trackingNumber);
//     }

//     public Delivery updateDeliveryStatus(Long deliveryId, DeliveryStatus status) {
//         Delivery delivery = deliveryRepository.findById(deliveryId)
//             .orElseThrow(() -> new RuntimeException("Delivery not found"));
//         delivery.setStatus(status);
//         return deliveryRepository.save(delivery);
//     }
//     // public Delivery createDelivery(Delivery delivery) {
//     //     return deliveryRepository.save(delivery);
//     // }

//     // public Delivery updateStatus(Long id, String status) {
//     //     Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery not found"));
//     //     delivery.setStatus(status);
//     //     return deliveryRepository.save(delivery);
//     // }

//     public void deleteDelivery(Long id) {
//         deliveryRepository.deleteById(id);
//     }
// }
