package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // ALIAS: Controller calls 'createLocation'
    public Location createLocation(Location location) {
        if (location.getCreatedAt() == null) {
            location.setCreatedAt(LocalDateTime.now());
        }
        return locationRepository.save(location);
    }

    // ALIAS: Controller calls 'getLocation'
    public Location getLocation(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
    }

    public Location getLocationByName(String name) {
        return locationRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Location not found with name: " + name));
    }
}