package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;
    private final SensorRepository sensorRepository;

    public SensorReadingServiceImpl(
            SensorReadingRepository sensorReadingRepository,
            SensorRepository sensorRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {

        if (sensorId == null) {
            throw new IllegalArgumentException("Sensor ID cannot be null");
        }

        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sensor not found with id: " + sensorId));

        if (reading.getReadingValue() == null || reading.getReadingValue() <= 0) {
            throw new IllegalArgumentException("Reading value must be greater than 0");
        }

        reading.setSensor(sensor);
        reading.setReadingTime(LocalDateTime.now());
        reading.setStatus("PENDING");

        return sensorReadingRepository.save(reading);
    }

    @Override
    public SensorReading getReading(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Reading ID cannot be null");
        }

        return sensorReadingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("SensorReading not found with id: " + id));
    }

    @Override
    public List<SensorReading> getReadingsBySensor(Long sensorId) {

        if (sensorId == null) {
            throw new IllegalArgumentException("Sensor ID cannot be null");
    }
        return sensorReadingRepository.findBySensor_Id(sensorId);
    }
}
