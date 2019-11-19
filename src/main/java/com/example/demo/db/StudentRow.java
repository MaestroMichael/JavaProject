package com.example.demo.db;

import com.example.demo.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    protected StudentRow(){}

    public Student toStudent(){return new Student(
            this.getId(),
            this.getName(),
            this.getNumer(),
            this.getGrupa()); }

    public StudentRow(String name,String numer,String grupa){
        this.name=name;
        this.numer=numer;
        this.grupa=grupa;
    }
}
