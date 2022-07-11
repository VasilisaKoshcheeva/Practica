package com.example.practica.entity;

import javax.persistence.*;


@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
