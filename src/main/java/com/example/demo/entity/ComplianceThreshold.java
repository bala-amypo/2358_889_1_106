package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorType;
    private Double maxValue;
    private String severityLevel;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public String getSensorType() {
        return sensorType;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }
}
