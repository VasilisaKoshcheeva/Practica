package com.example.practica.services;

import com.example.practica.dto.GroupDTO;
import com.example.practica.dto.ScheduleDTO;
import com.example.practica.entity.Cabinet;
import com.example.practica.entity.Group;
import com.example.practica.entity.Schedule;
import com.example.practica.repositories.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;


@Service
public class ScheduleService {
    private final ScheduleRepo scheduleRepo;
    private final TeacherRepo teacherRepo;
    private final SubjectRepo subjectRepo;
    private final CabinetRepo cabinetRepo;
    private final GroupRepo groupRepo;

    public ScheduleService(ScheduleRepo sr, TeacherRepo tr, SubjectRepo sur, CabinetRepo cr, GroupRepo gr){
        scheduleRepo = sr;
        teacherRepo = tr;
        subjectRepo = sur;
        cabinetRepo = cr;
        groupRepo = gr;
    }
    public Schedule getSchedule(int id){
        return scheduleRepo.findById(id).get();
    }
    public Schedule addSchedule(ScheduleDTO scheduleDTO) throws ParseException {
        Date date = Date.valueOf(scheduleDTO.getDateExam());
        Time time = Time.valueOf(scheduleDTO.getTimeExam());
        Schedule schedule  = new Schedule(
                teacherRepo.getReferenceById(scheduleDTO.getTeacher()),
                subjectRepo.getReferenceById(scheduleDTO.getSubject()),
                cabinetRepo.getReferenceById(scheduleDTO.getCabinet()),
                groupRepo.getReferenceById(scheduleDTO.getGroup()),
                time, date);
        return scheduleRepo.save(schedule);
    }
    public Schedule updateSchedule(ScheduleDTO scheduleDTO){
        Date date = Date.valueOf(scheduleDTO.getDateExam());
        Time time = Time.valueOf(scheduleDTO.getTimeExam());
        Schedule schedule  = new Schedule(
                scheduleDTO.getId(),
                teacherRepo.getReferenceById(scheduleDTO.getTeacher()),
                subjectRepo.getReferenceById(scheduleDTO.getSubject()),
                cabinetRepo.getReferenceById(scheduleDTO.getCabinet()),
                groupRepo.getReferenceById(scheduleDTO.getGroup()),
                time, date);
        if(scheduleRepo.findById(scheduleDTO.getId()).isPresent()){
            return scheduleRepo.save(schedule);
        }
        else{
            return null;
        }
    }
    public boolean deleteSchedule(int id){
        Optional<Schedule> op = scheduleRepo.findById(id);
        if(!op.isPresent()){
            return false;
        }
        scheduleRepo.delete(op.get());
        return true;
    }
}