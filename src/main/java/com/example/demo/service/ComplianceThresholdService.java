package com.example.demo.service;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.ComplianceThresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComplianceThresholdService {

    @Autowired
    private ComplianceThresholdRepository thresholdRepository;

    public List<ComplianceThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }

    // Fix: Add this method so Controllers can find it
    public ComplianceThreshold createThreshold(ComplianceThreshold threshold) {
        return thresholdRepository.save(threshold);
    }

    // Fix: Add this method so Controllers can find it
    public ComplianceThreshold getThreshold(Long id) {
        return thresholdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Threshold not found"));
    }

    public ComplianceThreshold getThresholdBySensorType(String sensorType) {
        // Fix: Return Optional from Repo or handle null here
        return thresholdRepository.findBySensorType(sensorType);
    }
}