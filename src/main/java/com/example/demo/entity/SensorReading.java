package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Sensor sensor;
    private Double value;
    private LocalDateTime timestamp;
    private String status;

    public SensorReading() {}
    public SensorReading(Long id, Sensor sensor, Double value, LocalDateTime timestamp, String status) {
        this.id = id; this.sensor = sensor; this.value = value; this.timestamp = timestamp; this.status = status;
    }

    public Sensor getSensor() { return this.sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }
    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }

    // Service Aliases
    public Double getReadingValue() { return this.value; }
    public void setReadingTime(LocalDateTime time) { this.timestamp = time; }
}