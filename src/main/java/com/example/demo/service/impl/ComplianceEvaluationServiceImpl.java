package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.entity.SensorReading;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ComplianceEvaluationServiceImpl implements ComplianceEvaluationService {

    @Autowired
    private ComplianceThresholdRepository thresholdRepository;

    @Override
    public String evaluateCompliance(SensorReading reading) {
        String type = reading.getSensor().getType();
        double value = reading.getValue();

        // FIX: Wrap the repository call in Optional so .orElseThrow() works
        ComplianceThreshold threshold = Optional.ofNullable(thresholdRepository.findBySensorType(type))
                .orElseThrow(() -> new RuntimeException("Threshold for " + type + " not found"));

        // These now exist because we added them to the Entity above
        if (value < threshold.getMinValue() || value > threshold.getMaxValue()) {
            return "NON-COMPLIANT";
        }

        return "COMPLIANT";
    }
}