package com.example.practica.services;

import com.example.practica.entity.Teacher;
import com.example.practica.repositories.TeacherRepo;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {
    private TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo tr){
        teacherRepo = tr;
    }
    public Teacher getTeacher(int id){
        return teacherRepo.findById(id).get();
    }
}
