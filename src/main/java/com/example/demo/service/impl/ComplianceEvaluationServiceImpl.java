package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.repository.SensorReadingRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl {

    private final SensorReadingRepository sensorReadingRepository;
    private final ComplianceThresholdRepository thresholdRepository;
    private final ComplianceLogRepository logRepository;

    public ComplianceEvaluationServiceImpl(SensorReadingRepository sensorReadingRepository,
                                           ComplianceThresholdRepository thresholdRepository,
                                           ComplianceLogRepository logRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.thresholdRepository = thresholdRepository;
        this.logRepository = logRepository;
    }

    public ComplianceLog evaluateReading(Long readingId) {
        if (readingId == null) {
            throw new IllegalArgumentException("Reading ID cannot be null");
        }
        
        SensorReading reading = sensorReadingRepository.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));

        ComplianceThreshold threshold = thresholdRepository.findBySensorType(reading.getSensor().getSensorType())
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        List<ComplianceLog> existingLogs = logRepository.findBySensorReading_Id(readingId);
        if (!existingLogs.isEmpty()) {
            return existingLogs.get(0);
        }

        String status = (reading.getReadingValue() >= threshold.getMinValue() && 
                         reading.getReadingValue() <= threshold.getMaxValue()) ? "SAFE" : "UNSAFE";

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);
        log.setThresholdUsed(threshold);
        log.setStatusAssigned(status);
        log.setLoggedAt(LocalDateTime.now());
        
        return logRepository.save(log);
    }

    public List<ComplianceLog> getLogsByReading(Long readingId) {
        if (readingId == null) {
            throw new IllegalArgumentException("Reading ID cannot be null");
        }
        
        return logRepository.findBySensorReading_Id(readingId);
    }

    public ComplianceLog getLog(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}