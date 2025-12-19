// package com.example.demo.service;

// import com.example.demo.entity.ComplianceThreshold;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.ComplianceThresholdRepository;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class ComplianceThresholdService {

//     private final ComplianceThresholdRepository thresholdRepository;

//     public ComplianceThresholdService(ComplianceThresholdRepository thresholdRepository) {
//         this.thresholdRepository = thresholdRepository;
//     }
//     public ComplianceThreshold createThreshold(ComplianceThreshold threshold) {
//         if (threshold.getSensorType() == null || threshold.getSensorType().isBlank()) {
//             throw new IllegalArgumentException("sensorType required");
//         }
//         if (threshold.getSeverityLevel() == null || threshold.getSeverityLevel().isBlank()) {
//             throw new IllegalArgumentException("severityLevel required");
//         }
//         if (threshold.getMinValue() == null 
//             || threshold.getMaxValue() == null
//             || threshold.getMinValue() >= threshold.getMaxValue()) {
//             throw new IllegalArgumentException("minvalue must be less than maxValue");
//         }
//         threshold.setCreatedAt(LocalDateTime.now());

//         return thresholdRepository.save(threshold);
//     }


//     public ComplianceThreshold getThreshold(Long id) {
//         return thresholdRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
//     }

//     public ComplianceThreshold getThresholdBySensorType(String sensorType) {
//         return thresholdRepository.findBySensorType(sensorType)
//             .orElseThrow(() -> new ResourceNotFoundException("Threshold not found"));
//     }

  
//     public List<ComplianceThreshold> getAllThresholds() {
//         return thresholdRepository.findAll();
//     }
// }
