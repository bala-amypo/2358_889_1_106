package com.example.demo.repository;

import com.example.demo.entity.ComplianceLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplianceLogRepository
        extends JpaRepository<ComplianceLog, Long> {

    Optional<ComplianceLog> findBySensorReading_Id(Long sensorReadingId);
}
