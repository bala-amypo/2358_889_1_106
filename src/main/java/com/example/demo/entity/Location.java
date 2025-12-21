package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String locationId;
    private String name; // Because this is 'name', the repo must use 'findByName'
    private String address;
    private LocalDateTime createdAt;

    public Location() {}

    public Location(Long id, String locationId, String name, String address, LocalDateTime createdAt) {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.createdAt = createdAt;
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLocationId() { return locationId; }
    public void setLocationId(String locationId) { this.locationId = locationId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // Service Aliases for backward compatibility with your other services
    public String getRegion() { return this.name; }
    public void setRegion(String region) { this.name = region; }
}
