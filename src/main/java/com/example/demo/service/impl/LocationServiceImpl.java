package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationServiceImpl {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(Location location) {
        if (location.getRegion() == null || location.getRegion().isBlank()) {
            throw new IllegalArgumentException("region required");
        }
        location.setCreatedAt(LocalDateTime.now());
        return locationRepository.save(location);
    }

    public Location getLocation(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        
        return locationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}