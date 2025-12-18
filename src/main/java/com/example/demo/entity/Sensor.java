package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "sensorCode"))
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorCode;
    private String sensorType;

    @ManyToOne
    private Location location;

    private LocalDateTime installedAt = LocalDateTime.now();
    private Boolean isActive = true;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSensorCode() {
        return sensorCode;
    }
    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }
    public String getSensorType() {
        return sensorType;
    }
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public LocalDateTime getInstalledAt() {
        return installedAt;
    }
    public void setInstalledAt(LocalDateTime installedAt) {
        this.installedAt = installedAt;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    
}
