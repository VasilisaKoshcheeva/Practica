package com.example.practica.services;

import com.example.practica.dto.ScheduleDTO;
import com.example.practica.entity.Schedule;
import com.example.practica.repositories.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;


@Service
public class ScheduleService {
    private final ScheduleRepo scheduleRepo;
    private final ConverterService converterService;

    public ScheduleService(ScheduleRepo sr, ConverterService converterService) {
        scheduleRepo = sr;
        this.converterService = converterService;
    }

    public Schedule getSchedule(int id) {
        return scheduleRepo.findById(id).get();
    }

    public Schedule addSchedule(ScheduleDTO scheduleDTO) throws ParseException {
        return scheduleRepo.save(converterService.converterScheduleDTO(scheduleDTO));
    }

    public Schedule updateSchedule(ScheduleDTO scheduleDTO) {
        if (scheduleRepo.findById(scheduleDTO.getId()).isPresent()) {
            return scheduleRepo.save(converterService.converterScheduleDTOWithId(scheduleDTO));
        } else {
            return null;
        }
    }

    public boolean deleteSchedule(int id) {
        Optional<Schedule> op = scheduleRepo.findById(id);
        if (!op.isPresent()) {
            return false;
        }
        scheduleRepo.delete(op.get());
        return true;
    }
}