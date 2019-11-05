package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NewStudent {

    //final String name;
    public final String name;
    public final String numer;
    public final String grupa;

    @JsonCreator
    public NewStudent(@JsonProperty("name") String name,  @JsonProperty("numer") String numer, @JsonProperty("grupa") String grupa) {
        this.name = name;
        this.numer = numer;
        this.grupa = grupa;
    }
}
