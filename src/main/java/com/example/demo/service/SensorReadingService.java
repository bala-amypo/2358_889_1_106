package com.example.demo.service;

import com.example.demo.entity.SensorReading;
import java.util.List;

public interface SensorReadingService {
    // These methods match exactly what your Controller is calling
    List<SensorReading> getAllReadings();
    SensorReading saveReading(SensorReading reading);
    
    // Standard utility methods
    SensorReading getReadingById(Long id);
    List<SensorReading> getReadingsBySensor(Long sensorId);
}