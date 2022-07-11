package com.example.practica.services;

import com.example.practica.dto.SubjectDTO;
import com.example.practica.entity.Subject;
import com.example.practica.repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SubjectService {
    private final SubjectRepo subjectRepo;
    private final ConverterService converterService;


    public SubjectService(SubjectRepo sr, ConverterService converterService) {
        subjectRepo = sr;
        this.converterService = converterService;
    }

    public Subject getSubject(int id) {
        return subjectRepo.findById(id).get();
    }

    public Subject addSubject(SubjectDTO subjectDTO) {
        return subjectRepo.save(converterService.converterSubjectDTO(subjectDTO));
    }

    public Subject updateSubject(SubjectDTO subjectDTO) {
        if (subjectRepo.findById(subjectDTO.getId()).isPresent()) {
            return subjectRepo.save(converterService.converterSubjectDTOWithId(subjectDTO));
        } else {
            return null;
        }
    }

    public boolean deleteSubject(int id) {
        Optional<Subject> op = subjectRepo.findById(id);
        if (!op.isPresent()) {
            return false;
        }
        subjectRepo.delete(op.get());
        return true;
    }
}
