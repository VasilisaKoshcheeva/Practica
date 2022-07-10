package com.example.practica.services;

import com.example.practica.dto.TeacherDTO;
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


    public Teacher addTeacher(TeacherDTO teacherDTO){
        Teacher teacher = new Teacher(teacherDTO.getLastName(),teacherDTO.getFirstName(),teacherDTO.getMiddleName());
        return teacherRepo.save(teacher);
    }
    public Teacher updateTeacher(TeacherDTO teacherDTO){
        if(teacherRepo.findById(teacherDTO.getId()).isPresent()){
            Teacher teacher = new Teacher(teacherDTO.getId(), teacherDTO.getLastName(),teacherDTO.getFirstName(),teacherDTO.getMiddleName());
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
