package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.entity.SensorReading;
import com.example.demo.repository.ComplianceLogRepository;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {
    
    private final SensorReadingRepository readingRepository;
    private final ComplianceThresholdRepository thresholdRepository;
    private final ComplianceLogRepository logRepository;
    
    @Autowired
    public ComplianceEvaluationServiceImpl(SensorReadingRepository readingRepository, 
                                         ComplianceThresholdRepository thresholdRepository,
                                         ComplianceLogRepository logRepository) {
        this.readingRepository = readingRepository;
        this.thresholdRepository = thresholdRepository;
        this.logRepository = logRepository;
    }
    
    @Override
    public ComplianceLog evaluateReading(Long readingId) {
        SensorReading reading = readingRepository.findById(readingId)
            .orElseThrow(() -> new RuntimeException("Reading not found"));
        
        List<ComplianceLog> existingLogs = logRepository.findBySensorReading_Id(readingId);
        if (!existingLogs.isEmpty()) {
            return existingLogs.get(0);
        }
        
        ComplianceThreshold threshold = thresholdRepository.findBySensorType(reading.getSensor().getSensorType())
            .orElseThrow(() -> new RuntimeException("Threshold not found"));
        
        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);
        
        double value = reading.getReadingValue();
        if (value < threshold.getMinValue() || value > threshold.getMaxValue()) {
            log.setStatusAssigned("UNSAFE");
        } else {
            log.setStatusAssigned("SAFE");
        }
        
        reading.setStatus("EVALUATED");
        readingRepository.save(reading);
        
        return logRepository.save(log);
    }
}