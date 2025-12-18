package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class Sensor {
    @id
    private Long id;

    @Column(unique=true)
    private String sensorCode;
    private String sensorType;
    @ManyToOne
    private Location location;
    private LocalDateTime installedAt;
    private Boolean isActive;
