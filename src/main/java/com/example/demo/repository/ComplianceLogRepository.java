package com.example.demo.repository;

import com.example.demo.entity.ComplianceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplianceLogRepository extends JpaRepository<ComplianceLog, Long> {
    // Finds logs related to a specific reading ID
    List<ComplianceLog> findBySensorReading_Id(Long sensorReadingId);
}