package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public Sensor create(@RequestBody Sensor sensor) {
        return sensorService.save(sensor);
    }

    @GetMapping
    public List<Sensor> getAll() {
        return sensorService.getAll();
    }
}
