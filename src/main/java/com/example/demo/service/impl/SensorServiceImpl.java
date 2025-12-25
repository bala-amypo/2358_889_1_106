package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.Sensor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl {

    private final SensorRepository sensorRepository;
    private final LocationRepository locationRepository;

    public SensorServiceImpl(SensorRepository sensorRepository, LocationRepository locationRepository) {
        this.sensorRepository = sensorRepository;
        this.locationRepository = locationRepository;
    }

    public Sensor createSensor(Long locationId, Sensor sensor) {
        if (locationId == null) {
            throw new IllegalArgumentException("Location ID cannot be null");
        }
        
        Location location = locationRepository.findById(locationId)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
        
        if (sensor.getSensorType() == null || sensor.getSensorType().isBlank()) {
            throw new IllegalArgumentException("sensorType");
        }
        
        sensor.setLocation(location);
        return sensorRepository.save(sensor);
    }

    public Sensor getSensor(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        
        return sensorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Sensor not found"));
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}