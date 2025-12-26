package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Compliance Thresholds")
public class ComplianceThresholdController {
    
    private final ComplianceThresholdService thresholdService;
    
    public ComplianceThresholdController(ComplianceThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }
    
    @PostMapping
    @Operation(summary = "Create threshold")
    public ResponseEntity<ComplianceThreshold> createThreshold(@RequestBody ComplianceThreshold threshold) {
        ComplianceThreshold created = thresholdService.createThreshold(threshold);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping
    @Operation(summary = "Get all thresholds")
    public ResponseEntity<List<ComplianceThreshold>> getAllThresholds() {
        List<ComplianceThreshold> thresholds = thresholdService.getAllThresholds();
        return ResponseEntity.ok(thresholds);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get threshold by ID")
    public ResponseEntity<ComplianceThreshold> getThreshold(@PathVariable Long id) {
        ComplianceThreshold threshold = thresholdService.getThreshold(id);
        return ResponseEntity.ok(threshold);
    }
    
    @GetMapping("/type/{sensorType}")
    @Operation(summary = "Get threshold by sensor type")
    public ResponseEntity<ComplianceThreshold> getThresholdBySensorType(@PathVariable String sensorType) {
        ComplianceThreshold threshold = thresholdService.getThresholdBySensorType(sensorType);
        return ResponseEntity.ok(threshold);
    }
}