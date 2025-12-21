package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private String type;
    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    
    private LocalDateTime createdAt;
    private Boolean active;

    // --- REQUIRED FOR TESTS ---
    public Sensor(Long id, String sensorId, String type, Location location, LocalDateTime createdAt, Boolean active) {
        this.id = id;
        this.sensorId = sensorId;
        this.type = type;
        this.location = location;
        this.createdAt = createdAt;
        this.active = active;
    }
    public Sensor() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSensorId() { return sensorId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}