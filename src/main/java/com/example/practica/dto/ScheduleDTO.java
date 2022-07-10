package com.example.practica.dto;

import com.example.practica.entity.Cabinet;
import com.example.practica.entity.Group;
import com.example.practica.entity.Subject;
import com.example.practica.entity.Teacher;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

public class ScheduleDTO {
    private int id;

    private int teacher;

    private int subject;

    private int cabinet;

    private int group;

    private String timeExam;

    private String dateExam;

    public ScheduleDTO(int teacher, int subject, int cabinet, int group, String timeExam, String dateExam) {
        this.teacher = teacher;
        this.subject = subject;
        this.cabinet = cabinet;
        this.group = group;
        this.timeExam = timeExam;
        this.dateExam = dateExam;
    }

    public ScheduleDTO(int id, int teacher, int subject, int cabinet, int group, String timeExam, String dateExam) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.cabinet = cabinet;
        this.group = group;
        this.timeExam = timeExam;
        this.dateExam = dateExam;
    }

    public ScheduleDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTimeExam() {
        return timeExam;
    }

    public void setTimeExam(String timeExam) {
        this.timeExam = timeExam;
    }

    public String getDateExam() {
        return dateExam;
    }

    public void setDateExam(String dateExam) {
        this.dateExam = dateExam;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
