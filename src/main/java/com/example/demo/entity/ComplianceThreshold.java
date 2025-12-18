package com.example.demo2.entity;

import java.time.LocalDateTime;

public class ComplianceThreshold {
      @Id
    private long id;
    private String sensorType;
    private double maxValue;
    private String severityLevel;
    private LocalDateTime createdAt;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSensorType() {
        return sensorType;
    }
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
    public double getMaxValue() {
        return maxValue;
    }
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }
    public String getSeverityLevel() {
        return severityLevel;
    }
    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    

}
