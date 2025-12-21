package com.example.demo.service.impl;

import com.example.demo.entity.SensorReading;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    @Autowired
    private SensorReadingRepository sensorReadingRepository;

    @Override
    public List<SensorReading> getAllReadings() {
        // Uses the JpaRepository findAll() method to get all data from the table
        return sensorReadingRepository.findAll();
    }

    @Override
    public SensorReading saveReading(SensorReading reading) {
        // Business Logic: Automatically set the timestamp if it's missing
        if (reading.getReadingTime() == null) {
            reading.setReadingTime(LocalDateTime.now());
        }
        
        // Logic: You can add compliance checks here later
        if (reading.getStatus() == null) {
            reading.setStatus("PENDING");
        }
        
        return sensorReadingRepository.save(reading);
    }

    @Override
    public SensorReading getReadingById(Long id) {
        return sensorReadingRepository.findById(id).orElse(null);
    }

    @Override
    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        // This matches the custom method we added to the Repository earlier
        return sensorReadingRepository.findBySensorId(sensorId);
    }
}