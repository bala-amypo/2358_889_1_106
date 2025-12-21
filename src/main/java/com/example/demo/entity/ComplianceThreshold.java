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

    // Getters for standard fields
    public String getSensorType() { return sensorType; }
    public Double getMinThreshold() { return minThreshold; }
    public Double getMaxThreshold() { return maxThreshold; }

    // ALIAS METHODS: These fix the "cannot find symbol" for getMinValue/getMaxValue
    public Double getMinValue() {
        return this.minThreshold;
    }

    public Double getMaxValue() {
        return this.maxThreshold;
    }
    
    // Setters
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public void setMinThreshold(Double minThreshold) { this.minThreshold = minThreshold; }
    public void setMaxThreshold(Double maxThreshold) { this.maxThreshold = maxThreshold; }
}