package com.example.practica.services;

import com.example.practica.dto.SubjectDTO;
import com.example.practica.entity.Group;
import com.example.practica.entity.Subject;
import com.example.practica.repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SubjectService {
    private SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo sr){
        subjectRepo = sr;
    }
    public Subject getSubject(int id){
        return subjectRepo.findById(id).get();
    }
    public Subject addSubject(SubjectDTO subjectDTO){
        Subject subject = new Subject(subjectDTO.getName());
        return subjectRepo.save(subject);
    }
    public Subject updateSubject(SubjectDTO subjectDTO){
        if(subjectRepo.findById(subjectDTO.getId()).isPresent()){
            Subject subject = new Subject(subjectDTO.getId(), subjectDTO.getName());
            return subjectRepo.save(subject);
        }
        else{
            return null;
        }
    }
    public boolean deleteSubject(int id){
        Optional<Subject> op = subjectRepo.findById(id);
        if(!op.isPresent()){
            return false;
        }
        subjectRepo.delete(op.get());
        return true;
    }
}
