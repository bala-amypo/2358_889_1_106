package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings")
public class SensorReadingController {
    
    private final SensorReadingService readingService;
    
    public SensorReadingController(SensorReadingService readingService) {
        this.readingService = readingService;
    }
    
    @PostMapping("/{sensorId}")
    @Operation(summary = "Submit reading")
    public ResponseEntity<SensorReading> submitReading(@PathVariable Long sensorId, @RequestBody SensorReading reading) {
        SensorReading created = readingService.submitReading(sensorId, reading);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/sensor/{sensorId}")
    @Operation(summary = "Get readings by sensor")
    public ResponseEntity<List<SensorReading>> getReadingsBySensor(@PathVariable Long sensorId) {
        List<SensorReading> readings = readingService.getReadingsBySensor(sensorId);
        return ResponseEntity.ok(readings);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get reading by ID")
    public ResponseEntity<SensorReading> getReading(@PathVariable Long id) {
        SensorReading reading = readingService.getReading(id);
        return ResponseEntity.ok(reading);
    }
}