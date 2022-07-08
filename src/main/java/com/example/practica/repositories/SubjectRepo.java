package com.example.practica.repositories;

import com.example.practica.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {
    Subject findById(int id);
}
