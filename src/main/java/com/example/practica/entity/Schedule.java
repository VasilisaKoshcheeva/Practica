package com.example.practica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_subject")
    private Subject subject;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cabinet")
    private Cabinet cabinet;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group")
    private Group group;
    @Column(name = "time_exam")
    private Time timeExam;
    @Column(name = "date_exam")
    private Date dateExam;

    public Schedule(int id, Teacher teacher, Subject subject, Cabinet cabinet, Group group, Time timeExam, Date dateExam) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.cabinet = cabinet;
        this.group = group;
        this.timeExam = timeExam;
        this.dateExam = dateExam;
    }

    public Schedule(Teacher teacher, Subject subject, Cabinet cabinet, Group group, Time timeExam, Date dateExam) {
        this.teacher = teacher;
        this.subject = subject;
        this.cabinet = cabinet;
        this.group = group;
        this.timeExam = timeExam;
        this.dateExam = dateExam;
    }

    public Schedule() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Time getTimeExam() {
        return timeExam;
    }

    public void setTimeExam(Time timeExam) {
        this.timeExam = timeExam;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }


}
