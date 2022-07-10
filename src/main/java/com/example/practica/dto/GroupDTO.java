package com.example.practica.dto;

import javax.persistence.Column;

public class GroupDTO {
    private int id;
    private String numb;
    private int course;
    private String directionCode;
    private String direction;

    public GroupDTO(int id, String numb, int course, String directionCode, String direction) {
        this.id = id;
        this.numb = numb;
        this.course = course;
        this.directionCode = directionCode;
        this.direction = direction;
    }

    public GroupDTO(String numb, int course, String directionCode, String direction) {
        this.numb = numb;
        this.course = course;
        this.directionCode = directionCode;
        this.direction = direction;
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

    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
