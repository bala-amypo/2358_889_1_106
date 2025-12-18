package com.example.demo.service;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.entity.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    Map<Integer,StudentEntity> mp = new HashMap<>();

    public StudentEntity savedata(StudentEntity st){
        mp.put(st.getId(),st);
        return  st;
    }
    public List<StudentEntity>retdata(){
        return new ArrayList<>(mp.values());
    }
    public StudentEntity id(int id) {
        return mp.get(id);
    }
    public StudentEntity ids(int id, StudentEntity st) {
        return mp.put(id,st);
    }
    public StudentEntity isd(int id) {
        return mp.remove(id);
    }
}