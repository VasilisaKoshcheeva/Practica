package com.example.practica.controller;

import com.example.practica.entity.Schedule;
import com.example.practica.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}