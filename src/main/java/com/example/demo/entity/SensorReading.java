package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

@Entity
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @NotNull(message = "readingvalue is required")
    @Column(nullable = false)
    private Double readingValue;

    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime readingTime;

    @Column(nullable = false)
    private String status;

    @PrePersist
    @PreUpdate
    public void setStatus() {
        if (readingValue == null) {
            return;
        }

        if (readingValue < 30) {
            status = "LOW";
        } else if (readingValue <= 70) {
            status = "NORMAL";
        } else {
            status = "HIGH";
        }
    }

    public Long getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(Double readingValue) {
        this.readingValue = readingValue;
    }

    public LocalDateTime getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(LocalDateTime readingTime) {
        this.readingTime = readingTime;
    }

    public String getStatus() {
        return status;
    }
}

