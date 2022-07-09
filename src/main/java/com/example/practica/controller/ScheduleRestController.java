package com.example.practica.controller;

import com.example.practica.entity.Cabinet;
import com.example.practica.entity.Schedule;
import com.example.practica.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/schedule-management")
public class ScheduleRestController {
    private final ScheduleService scheduleService;

    public ScheduleRestController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable int id){
        return new ResponseEntity(scheduleService.getSchedule(id), HttpStatus.OK);
    }
    @PostMapping("/schedule")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule){
        return new ResponseEntity(scheduleService.addSchedule(schedule), HttpStatus.CREATED);
    }
}