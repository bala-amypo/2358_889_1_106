package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorReadingServiceImpl {

    private final SensorReadingRepository sensorReadingRepository;
    private final SensorRepository sensorRepository;

    public SensorReadingServiceImpl(SensorReadingRepository sensorReadingRepository, 
                                    SensorRepository sensorRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.sensorRepository = sensorRepository;
    }

    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        if (sensorId == null) {
            throw new IllegalArgumentException("Sensor ID cannot be null");
        }
        
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor not found"));

        if (reading.getReadingValue() == null || reading.getReadingValue() == 0.0) {
            throw new IllegalArgumentException("readingvalue");
        }

        reading.setSensor(sensor);
        reading.setReadingTime(LocalDateTime.now());
        reading.setStatus("PENDING");
        
        return sensorReadingRepository.save(reading);
    }

    public SensorReading getReading(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        
        return sensorReadingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));
    }

    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        if (sensorId == null) {
            throw new IllegalArgumentException("Sensor ID cannot be null");
        }
        
        return sensorReadingRepository.findBySensor_Id(sensorId);
    }
}