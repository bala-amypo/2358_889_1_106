package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.entity.Sensor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final LocationRepository locationRepository;

    public SensorService(SensorRepository sensorRepository,
                         LocationRepository locationRepository) {
        this.sensorRepository = sensorRepository;
        this.locationRepository = locationRepository;
    }

    public Sensor createSensor(Long locationId, Sensor sensor) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        sensor.setLocation(location);
        return sensorRepository.save(sensor);
    }

    public Sensor getSensor(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor not found"));
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}
