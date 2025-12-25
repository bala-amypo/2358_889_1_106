package com.example.demo.controller;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceEvaluationService;

    public ComplianceEvaluationController(ComplianceEvaluationService complianceEvaluationService) {
        this.complianceEvaluationService = complianceEvaluationService;
    }

    @PostMapping("/evaluate/{readingId}")
    @Operation(summary = "Evaluate reading compliance", description = "Evaluates a sensor reading against compliance thresholds")
    public ResponseEntity<ComplianceLog> evaluateReading(@Parameter(name = "readingId", description = "Reading ID") @PathVariable Long readingId) {
        return ResponseEntity.ok(complianceEvaluationService.evaluateReading(readingId));
    }

    @GetMapping("/reading/{readingId}")
    @Operation(summary = "Get logs by reading", description = "Gets compliance logs for a specific reading")
    public ResponseEntity<List<ComplianceLog>> getLogsByReading(@Parameter(name = "readingId", description = "Reading ID") @PathVariable Long readingId) {
        return ResponseEntity.ok(complianceEvaluationService.getLogsByReading(readingId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get compliance log", description = "Gets a specific compliance log by ID")
    public ResponseEntity<ComplianceLog> getLog(@Parameter(name = "id", description = "Log ID") @PathVariable Long id) {
        return ResponseEntity.ok(complianceEvaluationService.getLog(id));
    }
}
