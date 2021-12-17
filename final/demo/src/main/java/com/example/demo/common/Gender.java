package com.example.demo.common;

import java.util.Enumeration;
import java.util.Objects;

public enum Gender {
    male(1, "male"),
    female(2, "female");

    private final Integer id;
    private final String code;



    Gender(int id, String code) {
        this.id = id;
        this.code = code;
    }


    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public static String getCode(int id) {
        for(Gender g : Gender.values()) {
            if(g.getId() == id) {
                return g.getCode();
            }
        }
        return null;
    }

    public static int getId(String code) {
        for(Gender g : Gender.values()) {
            if(Objects.equals(g.getCode(), code)) {
                return g.getId();
            }
        }
        return 0;
    }
}

