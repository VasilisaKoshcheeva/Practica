package com.example.practica.services;

import com.example.practica.dto.*;
import com.example.practica.entity.*;
import com.example.practica.repositories.CabinetRepo;
import com.example.practica.repositories.GroupRepo;
import com.example.practica.repositories.SubjectRepo;
import com.example.practica.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Service
public class ConverterService {
    @Autowired
    private final TeacherRepo teacherRepo;
    @Autowired
    private final SubjectRepo subjectRepo;
    @Autowired
    private final CabinetRepo cabinetRepo;
    @Autowired
    private final GroupRepo groupRepo;

    public ConverterService(TeacherRepo teacherRepo, SubjectRepo subjectRepo, CabinetRepo cabinetRepo, GroupRepo groupRepo) {
        this.teacherRepo = teacherRepo;
        this.subjectRepo = subjectRepo;
        this.cabinetRepo = cabinetRepo;
        this.groupRepo = groupRepo;
    }

    public Cabinet convertCabinetDTOWithId(CabinetDTO cabinetDTO) {
        return new Cabinet(cabinetDTO.getId(), cabinetDTO.getNumb());
    }

    public Group converterGroupDTOWithId(GroupDTO groupDTO) {
        return new Group(groupDTO.getId(), groupDTO.getNumb(), groupDTO.getCourse(), groupDTO.getDirectionCode(), groupDTO.getDirection());
    }

    public Schedule converterScheduleDTOWithId(ScheduleDTO scheduleDTO) {
        Date date = Date.valueOf(scheduleDTO.getDateExam());
        Time time = Time.valueOf(scheduleDTO.getTimeExam());
        return new Schedule(
                scheduleDTO.getId(),
                teacherRepo.getReferenceById(scheduleDTO.getTeacher()),
                subjectRepo.getReferenceById(scheduleDTO.getSubject()),
                cabinetRepo.getReferenceById(scheduleDTO.getCabinet()),
                groupRepo.getReferenceById(scheduleDTO.getGroup()),
                time, date);
    }

    public Subject converterSubjectDTOWithId(SubjectDTO subjectDTO) {
        return new Subject(subjectDTO.getId(), subjectDTO.getName());
    }

    public Teacher converterTeacherDTOWithId(TeacherDTO teacherDTO) {
        return new Teacher(teacherDTO.getId(), teacherDTO.getLastName(), teacherDTO.getFirstName(), teacherDTO.getMiddleName());
    }


    public Cabinet convertCabinetDTO(CabinetDTO cabinetDTO) {
        return new Cabinet(cabinetDTO.getNumb());
    }

    public Group converterGroupDTO(GroupDTO groupDTO) {
        return new Group(groupDTO.getNumb(), groupDTO.getCourse(), groupDTO.getDirectionCode(), groupDTO.getDirection());
    }

    public Schedule converterScheduleDTO(ScheduleDTO scheduleDTO) {
        Date date = Date.valueOf(scheduleDTO.getDateExam());
        Time time = Time.valueOf(scheduleDTO.getTimeExam());
        return new Schedule(
                teacherRepo.getReferenceById(scheduleDTO.getTeacher()),
                subjectRepo.getReferenceById(scheduleDTO.getSubject()),
                cabinetRepo.getReferenceById(scheduleDTO.getCabinet()),
                groupRepo.getReferenceById(scheduleDTO.getGroup()),
                time, date);
    }

    public Subject converterSubjectDTO(SubjectDTO subjectDTO) {
        return new Subject(subjectDTO.getName());
    }

    public Teacher converterTeacherDTO(TeacherDTO teacherDTO) {
        return new Teacher(teacherDTO.getLastName(), teacherDTO.getFirstName(), teacherDTO.getMiddleName());
    }

}
