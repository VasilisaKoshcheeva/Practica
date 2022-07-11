package com.example.practica.controller;

import com.example.practica.dto.ScheduleDTO;
import com.example.practica.entity.Schedule;
import com.example.practica.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@RequestMapping("/schedule-management")
public class ScheduleRestController {
    private final ScheduleService scheduleService;

    public ScheduleRestController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleDTO> getSchedule(@PathVariable int id) {
        return new ResponseEntity(scheduleService.getSchedule(id), HttpStatus.OK);
    }

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleDTO> addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        try {
            return new ResponseEntity(scheduleService.addSchedule(scheduleDTO), HttpStatus.CREATED);
        } catch (ParseException e) {
            System.out.println("Произошла ошибка в преобразовании даты, проверьте формат ГГГГ-ММ-ДД");
        }
        return null;
    }

    @PutMapping("/schedule")
    public ResponseEntity<ScheduleDTO> updateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return new ResponseEntity(scheduleService.updateSchedule(scheduleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<ScheduleDTO> deleteSchedule(@PathVariable int id) {
        boolean isRemoved = scheduleService.deleteSchedule(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}