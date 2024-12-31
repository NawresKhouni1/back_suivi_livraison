package com.Blockchain.blockchain.entity;


import java.util.List;


import jakarta.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String licenseNumber;
    private String phone;
    private Boolean availability;

    // @OneToMany(mappedBy = "assignedDriver")
    // private List<Delivery> deliveries;

    @ManyToOne
    private Truck truck;
    // Constructors
    public Driver() {}

    public Driver(String name, String licenseNumber, String phone, Boolean availability) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.availability = availability;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Boolean getAvailability() {
        return availability;
    }
    
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
    
    // public List<Delivery> getDeliveries() {
    //     return deliveries;
    // }
    
    // public void setDeliveries(List<Delivery> deliveries) {
    //     this.deliveries = deliveries;
    // }
    
    public Truck getVehicle() {
        return truck;
    }
    
    public void setVehicle(Truck truck) {
        this.truck = truck;
    }
}    