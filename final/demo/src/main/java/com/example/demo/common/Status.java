package com.example.demo.common;

import java.util.Objects;

public enum Status {
    Open(0, "Open"),
    On(1, "On"),
    Finish(2, "Finish"),
    Close(3, "Close");


    private final Integer id;
    private final String code;



    Status(int id, String code) {
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
        for(Status s : Status.values()) {
            if(s.getId() == id) {
                return s.getCode();
            }
        }
        return null;
    }

    public static int getId(String code) {
        for(Status s : Status.values()) {
            if(Objects.equals(s.getCode(), code)) {
                return s.getId();
            }
        }
        return 0;
    }

}

