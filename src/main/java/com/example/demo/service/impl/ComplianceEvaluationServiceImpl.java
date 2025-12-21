package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

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

    @Override
    public ComplianceLog evaluateReading(Long readingId) {
        SensorReading reading = sensorReadingRepository.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));

        // Now findBySensorType returns an Optional, so .orElseThrow() is a valid symbol!
        ComplianceThreshold threshold = thresholdRepository.findBySensorType(reading.getSensor().getSensorType())
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));

        String status = (reading.getReadingValue() >= threshold.getMinValue() && 
                         reading.getReadingValue() <= threshold.getMaxValue()) ? "SAFE" : "UNSAFE";

        reading.setStatus(status);
        sensorReadingRepository.save(reading);

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);
        log.setThresholdUsed(threshold);
        log.setStatusAssigned(status);
        log.setLoggedAt(LocalDateTime.now());
        
        return logRepository.save(log);
    }

    @Override
    public List<ComplianceLog> getLogsByReading(Long readingId) {
        return logRepository.findBySensorReadingId(readingId);
    }

    @Override
    public ComplianceLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}