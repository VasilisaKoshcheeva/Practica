package com.example.practica.dto;

import javax.persistence.Column;

public class CabinetDTO {
    private int id;
    private String numb;

    public CabinetDTO(int id, String numb) {
        this.id = id;
        this.numb = numb;
    }

    public CabinetDTO(String numb) {
        this.numb = numb;
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
