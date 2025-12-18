package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class Sensor {
    @id
    private Long id;

    @Column(unique=true)
    private String sensorCode;
    private String sensorType;
    @ManyToOne
    private Location location;
    @Column(name = "installed_at")
    private LocalDateTime installedAt;
    @Column(name = "is_active")
    private Boolean isActive;
    @PrePersist
    public void prePersist() {
        if (isActive == null) {
            isActive = true;
        }
        if (installedAt == null) {
            installedAt = LocalDateTime.now();
        }
    }
    public Long getId() {
        return id;
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
    public void setIsActive(Boolean active) {
        isActive = active;
    }
}