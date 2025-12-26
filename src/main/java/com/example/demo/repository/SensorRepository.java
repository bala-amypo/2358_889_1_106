package com.example.demo.repository;

import com.example.demo.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findBySensorCode(String sensorCode);
    List<Sensor> findByLocation_Region(String region);
}