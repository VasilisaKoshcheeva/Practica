package com.example.practica.repositories;

import com.example.practica.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
    Teacher findById(int id);
}
