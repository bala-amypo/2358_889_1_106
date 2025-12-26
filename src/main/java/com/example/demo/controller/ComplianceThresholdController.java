package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/thresholds")
public class ComplianceThresholdController {

    @Autowired
    private ComplianceThresholdService thresholdService;

    @PostMapping
    public ResponseEntity<ComplianceThreshold> createThreshold(@RequestBody ComplianceThreshold threshold) {
        return ResponseEntity.ok(thresholdService.createThreshold(threshold));
    }

    @GetMapping("/sensor-type/{sensorType}")
    public ResponseEntity<ComplianceThreshold> getThresholdBySensorType(@PathVariable String sensorType) {
        return ResponseEntity.ok(thresholdService.getThresholdBySensorType(sensorType));
    }
}