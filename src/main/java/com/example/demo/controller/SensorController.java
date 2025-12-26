package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping("/location/{locationId}")
    public ResponseEntity<Sensor> createSensor(@PathVariable Long locationId, @RequestBody Sensor sensor) {
        return ResponseEntity.ok(sensorService.createSensor(locationId, sensor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensor(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.getSensor(id));
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> getAllSensors() {
        return ResponseEntity.ok(sensorService.getAllSensors());
    }
}