package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Error {

    private String code;
    private String description;

    public Error() {

    }

    public Error(String code, String description) {
        this.code = code;
        this.description = description;
    }


}
