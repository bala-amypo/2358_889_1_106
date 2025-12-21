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

    public SensorReading() {}
    public SensorReading(Long id, Sensor sensor, Double value, LocalDateTime timestamp, String status) {
        this.id = id; this.sensor = sensor; this.value = value; this.timestamp = timestamp;
    }

    // ALIASES FOR SERVICE LAYER
    public Double getReadingValue() { return this.value; }
    public void setReadingValue(Double value) { this.value = value; }
    public LocalDateTime getReadingTime() { return this.timestamp; }
    public void setReadingTime(LocalDateTime time) { this.timestamp = time; }
}