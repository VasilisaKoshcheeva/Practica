package com.example.practica.controller;

import com.example.practica.entity.Subject;
import com.example.practica.services.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/subject-management")
public class SubjectRestController {
    private final SubjectService subjectService;

    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable int id){
        return new ResponseEntity(subjectService.getSubject(id), HttpStatus.OK);
    }
}
