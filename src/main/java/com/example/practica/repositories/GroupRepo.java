package com.example.practica.repositories;

import com.example.practica.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Integer> {
    //Group findById(int id);
}
