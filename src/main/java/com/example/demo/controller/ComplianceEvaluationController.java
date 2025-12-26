package com.example.demo.controller;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation")
public class ComplianceEvaluationController {
    
    private final ComplianceEvaluationService evaluationService;
    
    public ComplianceEvaluationController(ComplianceEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }
    
    @PostMapping("/evaluate/{readingId}")
    @Operation(summary = "Evaluate reading compliance")
    public ResponseEntity<ComplianceLog> evaluateReading(@PathVariable Long readingId) {
        ComplianceLog log = evaluationService.evaluateReading(readingId);
        return ResponseEntity.ok(log);
    }
    
    @GetMapping("/reading/{readingId}")
    @Operation(summary = "Get logs by reading")
    public ResponseEntity<List<ComplianceLog>> getLogsByReading(@PathVariable Long readingId) {
        List<ComplianceLog> logs = evaluationService.getLogsByReading(readingId);
        return ResponseEntity.ok(logs);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get log by ID")
    public ResponseEntity<ComplianceLog> getLog(@PathVariable Long id) {
        ComplianceLog log = evaluationService.getLog(id);
        return ResponseEntity.ok(log);
    }
}