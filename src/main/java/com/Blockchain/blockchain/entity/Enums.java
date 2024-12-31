package com.Blockchain.blockchain.entity;


public class Enums {

    // DeliveryStatus Enum
    public enum DeliveryStatus {
        EN_COURS,  // In progress
        LIVRÉE,     // Delivered
        RETURNED,  // Returned
        ANNULÉ     // Cancelled
    }

    // TruckType Enum
    public enum TruckType {
        VAN,      // Van
        CAMION,   // Truck
        SCOOTER   // Scooter
    }

    // TruckStatus Enum
    public enum TruckStatus {
        DISPONIBLE,    // Available
        EN_ROUTE,      // On the way
        MAINTENANCE    // Under maintenance
    }

}
