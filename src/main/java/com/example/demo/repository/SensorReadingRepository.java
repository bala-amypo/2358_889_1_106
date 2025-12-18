package com.example.demo.repository;

import org.springframework.jpa.repository.JpaRepository;

import com.example.demo.entity.SensorReading;

public interface SensorReadingRepository extends JpaRespository<SensorReading,Long>{

}