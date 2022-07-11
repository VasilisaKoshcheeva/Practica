package com.example.practica.controller;

import com.example.practica.dto.TeacherDTO;
import com.example.practica.entity.Subject;
import com.example.practica.entity.Teacher;
import com.example.practica.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teachers-management")
public class TeacherRestController {
    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<TeacherDTO> getTeacher(@PathVariable int id) {
        System.out.println(id);
        return new ResponseEntity(teacherService.getTeacher(id), HttpStatus.OK);
    }

    @PostMapping("/teacher")
    public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        return new ResponseEntity(teacherService.addTeacher(teacherDTO), HttpStatus.CREATED);
    }

    @PutMapping("/teacher")
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO) {
        return new ResponseEntity(teacherService.updateTeacher(teacherDTO), HttpStatus.OK);
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<TeacherDTO> deleteTeacher(@PathVariable int id) {
        boolean isRemoved = teacherService.deleteTeacher(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
