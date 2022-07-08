package com.example.practica.services;

import com.example.practica.entity.Subject;
import com.example.practica.repositories.SubjectRepo;
import org.springframework.stereotype.Service;


@Service
public class SubjectService {
    private SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo sr){
        subjectRepo = sr;
    }
    public Subject getSubject(int id){
        return subjectRepo.findById(id).get();
    }
}
