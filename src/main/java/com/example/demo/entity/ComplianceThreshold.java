package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String sensorType;
    private Double minThreshold;
    private Double maxThreshold;

    public ComplianceThreshold() {}

    // Standard Getters
    public String getSensorType() { return sensorType; }
    
    // Alias getters to match the Service Implementation logic
    public Double getMinValue() { return minThreshold; }
    public Double getMaxValue() { return maxThreshold; }

    // Setters
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public void setMinThreshold(Double minThreshold) { this.minThreshold = minThreshold; }
    public void setMaxThreshold(Double maxThreshold) { this.maxThreshold = maxThreshold; }
}