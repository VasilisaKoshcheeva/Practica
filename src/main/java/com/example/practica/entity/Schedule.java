package com.example.practica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Column
    @Id
    @GeneratedValue
    private int id;
    //@JsonIgnore
    //@OneToMany(mappedBy = "teacher")
    @ManyToOne (fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    //@JsonIgnore
    //@OneToMany(mappedBy = "subject")
    @ManyToOne (fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    @JoinColumn(name = "id_subject")
    private Subject subject;
    //@JsonIgnore
    //@OneToMany(mappedBy = "cabinet")
    @ManyToOne (fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    @JoinColumn(name = "id_cabinet")
    private Cabinet cabinet;
    //@JsonIgnore
    //@OneToMany(mappedBy = "group")
    @ManyToOne (fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    @JoinColumn(name = "id_group")
    private Group group;
    @Column(name = "time_exam")
    private String timeExam;
    @Column(name = "date_exam")
    private String dateExam;

    public Schedule(int id, Teacher teacher, Subject subject, Cabinet cabinet, Group group, String timeExam, String dateExam) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.cabinet = cabinet;
        this.group = group;
        this.timeExam = timeExam;
        this.dateExam = dateExam;
    }

    public Schedule(Teacher teacher, Subject subject, Cabinet cabinet, Group group, String timeExam, String dateExam) {
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


}
