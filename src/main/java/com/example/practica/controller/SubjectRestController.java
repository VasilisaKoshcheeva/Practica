package com.example.practica.controller;

import com.example.practica.dto.SubjectDTO;
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
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable int id) {
        return new ResponseEntity(subjectService.getSubject(id), HttpStatus.OK);
    }

    @PostMapping("/subject")
    public ResponseEntity<SubjectDTO> addSubject(@RequestBody SubjectDTO subjectDTO) {
        return new ResponseEntity(subjectService.addSubject(subjectDTO), HttpStatus.CREATED);
    }

    @PutMapping("/subject")
    public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO) {
        return new ResponseEntity(subjectService.updateSubject(subjectDTO), HttpStatus.OK);
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<SubjectDTO> deleteSubject(@PathVariable int id) {
        boolean isRemoved = subjectService.deleteSubject(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
