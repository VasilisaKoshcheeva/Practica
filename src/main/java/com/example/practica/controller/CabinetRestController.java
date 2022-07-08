package com.example.practica.controller;

import com.example.practica.entity.Cabinet;
import com.example.practica.services.CabinetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cabinet-management")
public class CabinetRestController {
    private final CabinetService cabinetService;

    public CabinetRestController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @GetMapping("/cabinet/{id}")
    public ResponseEntity<Cabinet> getCabinet(@PathVariable int id){
        return new ResponseEntity(cabinetService.getCabinet(id), HttpStatus.OK);
    }
}
