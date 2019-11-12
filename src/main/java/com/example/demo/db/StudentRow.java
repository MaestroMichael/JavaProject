package com.example.demo.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentRow {
    @Id
    private long id;
    private String name;
    private String numer;
    private String grupa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public StudentRow() {
    }
}
