package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors")
public class SensorController {
    
    private final SensorService sensorService;
    
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }
    
    @PostMapping("/{locationId}")
    @Operation(summary = "Create sensor")
    public ResponseEntity<Sensor> createSensor(@PathVariable Long locationId, @RequestBody Sensor sensor) {
        Sensor created = sensorService.createSensor(locationId, sensor);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping
    @Operation(summary = "Get all sensors")
    public ResponseEntity<List<Sensor>> getAllSensors() {
        List<Sensor> sensors = sensorService.getAllSensors();
        return ResponseEntity.ok(sensors);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get sensor by ID")
    public ResponseEntity<Sensor> getSensor(@PathVariable Long id) {
        Sensor sensor = sensorService.getSensor(id);
        return ResponseEntity.ok(sensor);
    }
}