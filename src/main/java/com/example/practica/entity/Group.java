package com.example.practica.entity;

import javax.persistence.*;

@Entity
@Table(name = "studgroup")
public class Group {
    @Column
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String numb;
    @Column
    private int course;
    @Column(name = "direction_code")
    private String directionCode;
    @Column
    private String direction;

    public Group(int id, String numb, int course, String direction_code, String direction) {
        this.id = id;
        this.numb = numb;
        this.course = course;
        this.directionCode = direction_code;
        this.direction = direction;
    }
    public Group(String numb, int course, String direction_code, String direction) {
        this.numb = numb;
        this.course = course;
        this.directionCode = direction_code;
        this.direction = direction;
    }

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(String direction_code) {
        this.directionCode = direction_code;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
