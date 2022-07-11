package com.example.practica.services;

import com.example.practica.dto.TeacherDTO;
import com.example.practica.entity.Teacher;
import com.example.practica.repositories.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;
    private final ConverterService converterService;


    public TeacherService(TeacherRepo tr, ConverterService converterService) {
        teacherRepo = tr;
        this.converterService = converterService;
    }

    public Teacher getTeacher(int id) {
        return teacherRepo.findById(id).get();
    }


    public Teacher addTeacher(TeacherDTO teacherDTO) {
        return teacherRepo.save(converterService.converterTeacherDTO(teacherDTO));
    }

    public Teacher updateTeacher(TeacherDTO teacherDTO) {
        if (teacherRepo.findById(teacherDTO.getId()).isPresent()) {
            return teacherRepo.save(converterService.converterTeacherDTOWithId(teacherDTO));
        } else {
            return null;
        }
    }

    public boolean deleteTeacher(int id) {
        Optional<Teacher> op = teacherRepo.findById(id);
        if (!op.isPresent()) {
            return false;
        }
        teacherRepo.delete(op.get());
        return true;
    }
}
