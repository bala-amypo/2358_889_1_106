//Sensor reading 
package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings Endpoints")
public class SensorReadingController {

    private final SensorReadingService readingService;

    public SensorReadingController(SensorReadingService readingService) {
        this.readingService = readingService;
    }

    @PostMapping("/{sensorId}")
    public ResponseEntity<SensorReading> submitReading(
            @PathVariable Long sensorId,
            @RequestBody SensorReading reading) {
        return ResponseEntity.ok(readingService.submitReading(sensorId, reading));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorReading> getReading(@PathVariable Long id) {
        return ResponseEntity.ok(readingService.getReading(id));
    }

    @GetMapping("/sensor/{sensorId}")
    public ResponseEntity<List<SensorReading>> getBySensor(@PathVariable Long sensorId) {
        return ResponseEntity.ok(readingService.getReadingsBySensor(sensorId));
    }
}
