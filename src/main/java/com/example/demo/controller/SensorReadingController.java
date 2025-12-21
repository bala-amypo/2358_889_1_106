package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    @Autowired
    private SensorReadingService readingService;

    @GetMapping
    public List<SensorReading> getAllReadings() {
        return readingService.getAllReadings();
    }

    @PostMapping
    public SensorReading createReading(@RequestBody SensorReading reading) {
        return readingService.saveReading(reading);
    }
}