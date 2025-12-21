package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
    
    private Double value;
    private LocalDateTime timestamp;
    private String status;

    public SensorReading() {}

    public SensorReading(Long id, Sensor sensor, Double value, LocalDateTime timestamp, String status) {
        this.id = id;
        this.sensor = sensor;
        this.value = value;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Sensor getSensor() { return sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }
    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Service Layer Aliases (Required by your ServiceImpl)
    public LocalDateTime getReadingTime() { return this.timestamp; }
    public void setReadingTime(LocalDateTime readingTime) { this.timestamp = readingTime; }
    public Double getReadingValue() { return this.value; }
}