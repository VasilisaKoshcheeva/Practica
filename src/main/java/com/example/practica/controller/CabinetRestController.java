package com.example.practica.controller;

import com.example.practica.entity.Cabinet;
import com.example.practica.services.CabinetService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @PostMapping("/cabinet")
    public ResponseEntity<Cabinet> addCabinet(@RequestBody Cabinet cabinet){
        return new ResponseEntity(cabinetService.addCabinet(cabinet), HttpStatus.CREATED);
    }
    @PutMapping("/cabinet")
    public ResponseEntity<Cabinet> updateCabinet(@RequestBody Cabinet cabinet){
        return  new ResponseEntity(cabinetService.updateCabinet(cabinet), HttpStatus.OK);
    }
    @DeleteMapping("/cabinet/{id}")
    public ResponseEntity<Cabinet>  deleteCabinet(@PathVariable int id){
        boolean isRemoved = cabinetService.deleteCabinet(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
