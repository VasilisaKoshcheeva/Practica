package com.example.practica.entity;

import javax.persistence.*;

@Entity
@Table(name = "cabinet")
public class Cabinet {
    @Column
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String numb;

    public Cabinet(int id, String number){
        numb = number;
        this.id = id;
    }
    public Cabinet( String number){
        numb = number;
    }

    public Cabinet() {

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
}
