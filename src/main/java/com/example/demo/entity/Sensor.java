package com.example.demo.entity;

import java.time.LocalDate;
import java.persistence.Column;

public class StudentEntity {
    private Long id;
    @column(message="unique")
    private String sensorCode;
    
    private LocalDate date;
    private float cgpa;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public float getCgpa() {
        return cgpa;
    }
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
    public StudentEntity(String name, int id, LocalDate date, float cgpa) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.cgpa = cgpa;
    }
    

}