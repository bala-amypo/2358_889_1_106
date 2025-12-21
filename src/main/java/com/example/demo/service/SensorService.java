package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepo;
    private final LocationRepository locationRepo;

    public SensorService(SensorRepository sensorRepo, LocationRepository locationRepo) {
        this.sensorRepo = sensorRepo;
        this.locationRepo = locationRepo;
    }

    @SuppressWarnings("null")
    public Sensor createSensor(Long locationId, Sensor sensor) {
        if (sensor.getSensorType() == null)
            throw new IllegalArgumentException("sensorType");

        Location loc = locationRepo.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        sensor.setLocation(loc);
        return sensorRepo.save(sensor);
    }

    @SuppressWarnings("null")
    public Sensor getSensor(Long id) {
        return sensorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<Sensor> getAllSensors() {
        return sensorRepo.findAll();
    }
}
