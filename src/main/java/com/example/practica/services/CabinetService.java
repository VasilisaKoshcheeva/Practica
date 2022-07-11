package com.example.practica.services;

import com.example.practica.dto.CabinetDTO;
import com.example.practica.entity.Cabinet;
import com.example.practica.repositories.CabinetRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CabinetService {
    private final CabinetRepo cabinetRepo;
    private final ConverterService converterService;


    public CabinetService(CabinetRepo cr, ConverterService converterService) {
        cabinetRepo = cr;
        this.converterService = converterService;
    }

    public Cabinet getCabinet(int id) {
        return cabinetRepo.findById(id).get();
    }

    public Cabinet addCabinet(CabinetDTO cabinetDTO) {
        return cabinetRepo.save(converterService.convertCabinetDTO(cabinetDTO));
    }

    public Cabinet updateCabinet(CabinetDTO cabinetDTO) {
        if (cabinetRepo.findById(cabinetDTO.getId()).isPresent()) {
            return cabinetRepo.save(converterService.convertCabinetDTOWithId(cabinetDTO));
        } else {
            return null;
        }
    }

    public boolean deleteCabinet(int id) {
        Optional<Cabinet> op = cabinetRepo.findById(id);
        if (!op.isPresent()) {
            return false;
        }
        cabinetRepo.delete(op.get());
        return true;
    }

}
