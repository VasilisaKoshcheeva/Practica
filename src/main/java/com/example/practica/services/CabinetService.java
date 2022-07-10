package com.example.practica.services;

import com.example.practica.entity.Cabinet;
import com.example.practica.repositories.CabinetRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CabinetService {
    private final CabinetRepo cabinetRepo;

    public CabinetService(CabinetRepo cr){
        cabinetRepo = cr;
    }
    public Cabinet getCabinet(int id){
        return cabinetRepo.findById(id).get();
    }
    public Cabinet addCabinet(Cabinet cabinet){
        return cabinetRepo.save(cabinet);
    }
    public Cabinet updateCabinet(Cabinet cabinet){
        if(cabinetRepo.findById(cabinet.getId()).isPresent()){
            return cabinetRepo.save(cabinet);
        }
        else{
            return null;
        }
    }
    public boolean deleteCabinet(int id){
        Optional<Cabinet> op = cabinetRepo.findById(id);
        if(!op.isPresent()){
            return false;
        }
        cabinetRepo.delete(op.get());
        return true;
    }

}
