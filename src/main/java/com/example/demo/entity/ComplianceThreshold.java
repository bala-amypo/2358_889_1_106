package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceThreshold {
    @Id
    private Long id;
    private String sensorType;
    private Double min;
    private Double max;
    private String severity;

    public ComplianceThreshold() {}

    // ALIASES FOR SERVICE LAYER
    public Double getMinValue() { return this.min; }
    public Double getMaxValue() { return this.max; }
    public String getSeverityLevel() { return this.severity; }
}