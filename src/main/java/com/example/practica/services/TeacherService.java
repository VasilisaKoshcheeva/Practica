package com.example.practica.services;

import com.example.practica.entity.Subject;
import com.example.practica.entity.Teacher;
import com.example.practica.repositories.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TeacherService {
    private TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo tr){
        teacherRepo = tr;
    }
    public Teacher getTeacher(int id){
        return teacherRepo.findById(id).get();
    }


    public Teacher addTeacher(Teacher teacher){
        return teacherRepo.save(teacher);
    }
    public Teacher updateTeacher(Teacher teacher){
        if(teacherRepo.findById(teacher.getId()).isPresent()){
            return teacherRepo.save(teacher);
        }
        else{
            return null;
        }
    }
    public boolean deleteTeacher(int id){
        Optional<Teacher> op = teacherRepo.findById(id);
        if(!op.isPresent()){
            return false;
        }
        teacherRepo.delete(op.get());
        return true;
    }
}
