package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {

    private final ComplianceThresholdService thresholdService;

    public ComplianceThresholdController(ComplianceThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @PostMapping
    public ResponseEntity<ComplianceThreshold> createThreshold(
            @RequestBody ComplianceThreshold threshold) {
        return ResponseEntity.ok(thresholdService.createThreshold(threshold));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplianceThreshold> getThreshold(@PathVariable Long id) {
        return ResponseEntity.ok(thresholdService.getThreshold(id));
    }

    @GetMapping("/type/{sensorType}")
    public ResponseEntity<ComplianceThreshold> getBySensorType(
            @PathVariable String sensorType) {
        return ResponseEntity.ok(thresholdService.getThresholdBySensorType(sensorType));
    }

    @GetMapping
    public ResponseEntity<List<ComplianceThreshold>> getAllThresholds() {
        return ResponseEntity.ok(thresholdService.getAllThresholds());
    }
}
