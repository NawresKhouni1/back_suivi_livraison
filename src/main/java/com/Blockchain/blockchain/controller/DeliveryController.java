package com.Blockchain.blockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Blockchain.blockchain.dto.DeliveryDTO;

import com.Blockchain.blockchain.service.DeliveryService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/admin/api-deliveries")
public class DeliveryController {

    // @Autowired
    // private DeliveryService deliveryService;

//     // Get all deliveries
//     @GetMapping("/get-all-deliveries")
//     public List<Delivery> getAllDeliveries() {
//         return deliveryService.getAllDeliveries();
//     }

//     // Get a specific delivery by ID
//     @GetMapping("/get-delivery-by-id/{id}")
//     public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
//         return deliveryService.getDeliveryById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     // Create a new delivery
//     @PostMapping("/add-delivery")
//     public Delivery createDelivery(@RequestBody Delivery delivery) {
//         return deliveryService.createDelivery(delivery);
//         // return new ResponseEntity<>(createdDelivery, HttpStatus.CREATED);

//     }
//     @GetMapping("/get-delivery-by-trackNumber/{trackingNumber}")
//     public ResponseEntity<Delivery> getDeliveryByTrackingNumber(@PathVariable String trackNumber) {
//         return deliveryService.findDeliveryByTrackingNumber(trackNumber)
//             .map(ResponseEntity::ok)
//             .orElse(ResponseEntity.notFound().build());
//     }

//     // Update delivery status
//     @PutMapping("/put-delivery/{id}/status")
//     public ResponseEntity<Delivery> updateDeliveryStatus(
//         @PathVariable Long id,
//         @RequestParam DeliveryStatus status) {
//     return ResponseEntity.ok(deliveryService.updateDeliveryStatus(id, status));
// }
//     // public ResponseEntity<Delivery> updateStatus(@PathVariable Long id, @RequestBody String status) {
//     //     try {
//     //         Delivery updatedDelivery = deliveryService.updateStatus(id, status);
//     //         return ResponseEntity.ok(updatedDelivery);
//     //     } catch (RuntimeException e) {
//     //         return ResponseEntity.notFound().build();
//     //     }
//     // }

//     // Delete a delivery
//     @DeleteMapping("/admin/api/deliveries/delete-delivery/{id}")
//     public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
//         deliveryService.deleteDelivery(id);
//         return ResponseEntity.noContent().build();
//     }
// }
 // Create a new delivery or update an existing one
 @Autowired
 private DeliveryService deliveryService;

 // Get all deliveries
 @GetMapping("/get-all-deliveries")
 public List<DeliveryDTO> getAllDeliveries() {
     return deliveryService.getAllDeliveries();
 }

 // Get a specific delivery by ID
 @GetMapping("/get-delivery-by-id/{id}")
 public DeliveryDTO getDeliveryById(@PathVariable Long id) {
     return deliveryService.getDeliveryById(id);
 }

 // Create or update a delivery
 @PostMapping("/add-delivery")
 public DeliveryDTO saveDelivery(@RequestBody DeliveryDTO deliveryDTO) {
     return deliveryService.saveDelivery(deliveryDTO);
 }
}