package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private String type;
    @ManyToOne
    private Location location;

    public Sensor() {}
    public Sensor(Long id, String sensorId, String type, Location location, LocalDateTime createdAt, Boolean active) {
        this.id = id; this.sensorId = sensorId; this.type = type; this.location = location;
    }

    // ALIAS FOR SERVICE LAYER
    public String getSensorType() { return this.type; }
    public void setSensorType(String sensorType) { this.type = sensorType; }
}