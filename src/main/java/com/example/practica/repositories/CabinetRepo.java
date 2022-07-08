package com.example.practica.repositories;

import com.example.practica.entity.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinetRepo extends JpaRepository<Cabinet,Integer> {
    //Cabinet findById(int id);
}
