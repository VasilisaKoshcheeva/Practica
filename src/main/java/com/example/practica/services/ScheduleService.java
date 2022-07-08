package com.example.practica.services;

import com.example.practica.entity.Schedule;
import com.example.practica.repositories.ScheduleRepo;
import org.springframework.stereotype.Service;


@Service
public class ScheduleService {
    private ScheduleRepo scheduleRepo;

    public ScheduleService(ScheduleRepo sr){
        scheduleRepo = sr;
    }
    public Schedule getSchedule(int id){
        return scheduleRepo.findById(id).get();
    }
}