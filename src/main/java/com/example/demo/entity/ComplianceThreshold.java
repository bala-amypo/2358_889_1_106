package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorType;
    private Double min;
    private Double max;
    private String severity;
    private LocalDateTime createdAt;

    public ComplianceThreshold() {}
    public ComplianceThreshold(Long id, String sensorType, Double min, Double max, String severity, LocalDateTime createdAt) {
        this.id = id; this.sensorType = sensorType; this.min = min; this.max = max; this.severity = severity; this.createdAt = createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public String getSensorType() { return this.sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }

    // Service Aliases
    public Double getMinValue() { return this.min; }
    public Double getMaxValue() { return this.max; }
    public String getSeverityLevel() { return this.severity; }
}