package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_logs")
public class ComplianceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "sensor_reading_id")
    private SensorReading sensorReading;
    
    @Column(nullable = false)
    private String statusAssigned;
    
    @Column(nullable = false)
    private LocalDateTime evaluationTime = LocalDateTime.now();

    public ComplianceLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public SensorReading getSensorReading() { return sensorReading; }
    public void setSensorReading(SensorReading sensorReading) { this.sensorReading = sensorReading; }
    
    public String getStatusAssigned() { return statusAssigned; }
    public void setStatusAssigned(String statusAssigned) { this.statusAssigned = statusAssigned; }
    
    public LocalDateTime getEvaluationTime() { return evaluationTime; }
    public void setEvaluationTime(LocalDateTime evaluationTime) { this.evaluationTime = evaluationTime; }
}