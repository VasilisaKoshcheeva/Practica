package com.example.practica.services;

import com.example.practica.entity.Cabinet;
import com.example.practica.repositories.CabinetRepo;
import org.springframework.stereotype.Service;


@Service
public class CabinetService {
    private CabinetRepo cabinetRepo;

    public CabinetService(CabinetRepo cr){
        cabinetRepo = cr;
    }
    public Cabinet getCabinet(int id){
        return cabinetRepo.findById(id).get();
    }
}
