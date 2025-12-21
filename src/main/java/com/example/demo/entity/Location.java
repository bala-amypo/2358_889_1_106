package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String locationId;
    private String name;
    private String address;
    private LocalDateTime createdAt;

    public Location() {}
    public Location(Long id, String locationId, String name, String address, LocalDateTime createdAt) {
        this.id = id; this.locationId = locationId; this.name = name; this.address = address; this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    // Service Aliases
    public String getRegion() { return this.name; }
    public void setRegion(String region) { this.name = region; }
}