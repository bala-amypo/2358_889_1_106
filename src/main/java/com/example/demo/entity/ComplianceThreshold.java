package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorType;
    private Double min; // "min" in test, might be named "minValue" in your code, change to match
    private Double max;
    private String severity;
    private LocalDateTime createdAt;

    // --- REQUIRED FOR TESTS ---
    public ComplianceThreshold(Long id, String sensorType, Double min, Double max, String severity, LocalDateTime createdAt) {
        this.id = id;
        this.sensorType = sensorType;
        this.min = min;
        this.max = max;
        this.severity = severity;
        this.createdAt = createdAt;
    }
    public ComplianceThreshold() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public Double getMin() { return min; }
    public void setMin(Double min) { this.min = min; }
    public Double getMax() { return max; }
    public void setMax(Double max) { this.max = max; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}