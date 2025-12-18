package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    StudentService src;
    @PostMapping("/post")
    public Sensor postdata(@RequestBody Sensor st){
    return src.savedata(st);

    }
    @GetMapping("/Get")
    public List<Sensor>getdata(){
        return src.retdata();
    }
    @GetMapping("/Getid/{id}")
    public Sensor getIdval(@PathVariable int id){
        return src.id(id);
    }
    @PutMapping("/update/{id}")
    public Sensor funName (@PathVariable int id,@RequestBody Sensor st){
    return src.ids(id,st);
}
@DeleteMapping("/delete/{id}")
public Sensor delData(@PathVariable int id){
    return src.isd(id);
}
}