package com.example.practica.controller;

import com.example.practica.entity.Group;
import com.example.practica.entity.Subject;
import com.example.practica.services.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/subject")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){
        return new ResponseEntity(subjectService.addSubject(subject), HttpStatus.CREATED);
    }
    @PutMapping("/subject")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
        return new ResponseEntity(subjectService.updateSubject(subject), HttpStatus.OK);
    }
    @DeleteMapping("/subject/{id}")
    public ResponseEntity<Subject>  deleteSubject(@PathVariable int id){
        boolean isRemoved = subjectService.deleteSubject(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
