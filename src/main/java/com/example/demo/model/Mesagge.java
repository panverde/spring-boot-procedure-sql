package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Mesagge {

    private String code;
    private String description;

    public Mesagge() {

    }

    public Mesagge(String code, String description) {
        this.code = code;
        this.description = description;
    }


}
