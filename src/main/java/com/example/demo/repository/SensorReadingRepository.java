package com.example.demo.repository;

import com.example.demo.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {
    // Finds readings by the ID of the related Sensor object
    List<SensorReading> findBySensor_Id(Long sensorId);
    
    // Finds readings for a sensor within a time range
    List<SensorReading> findBySensor_IdAndTimestampBetween(Long sensorId, LocalDateTime start, LocalDateTime end);
}