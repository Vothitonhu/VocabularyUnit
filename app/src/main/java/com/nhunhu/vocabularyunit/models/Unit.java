package com.nhunhu.vocabularyunit.models;

import java.io.Serializable;

public class Unit implements Serializable {
    public static final String FIELD_ID = "unitId";
    public static final String FIELD_TITLE_EN = "titleEN";
    public static final String FIELD_TITLE_VI = "titleVI";

    private int id;
    private String titleEN;
    private String titleVI;

    public Unit(int id, String titleEN, String titleVI) {
        this.id = id;
        this.titleEN = titleEN;
        this.titleVI = titleVI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleEN() {
        return titleEN;
    }

    public void setTitleEN(String titleEN) {
        this.titleEN = titleEN;
    }

    public String getTitleVI() {
        return titleVI;
    }

    public void setTitleVI(String titleVI) {
        this.titleVI = titleVI;
    }

    @Override
    public String toString() {
        return "Unit: " + id +
                ", titleEN='" + titleEN + '\'' +
                ", titleVI='" + titleVI;
    }
}
