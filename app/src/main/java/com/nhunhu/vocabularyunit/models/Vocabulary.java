package com.nhunhu.vocabularyunit.models;

import java.io.Serializable;

public class Vocabulary implements Serializable {
    public static final String FIELD_UNIT_ID = "unitId";
    public static final String FIELD_WORD = "word";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_PRONUNCIATION= "pronunciation";
    public static final String FIELD_MEAN = "vietnameseMean";
    public static final String FIELD_EXAMPLE = "example";

    private int unitId;
    private String word;
    private String type;
    private String pronunciation;
    private String mean;
    private String example;

    public Vocabulary(int unitId, String word, String type, String pronunciation, String mean, String example) {
        this.unitId = unitId;
        this.word = word;
        this.type = type;
        this.pronunciation = pronunciation;
        this.mean = mean;
        this.example = example;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return word + "\n" + type + "\n" + pronunciation + "\n" + mean + "\n"+ example;
//        "Vocabulary{" +
//                "unitId=" + unitId +
//                ", word='" + word + '\'' +
//                ", type='" + type + '\'' +
//                ", pronunciation='" + pronunciation + '\'' +
//                ", mean='" + mean + '\'' +
//                ", example='" + example + '\'' +
//                '}';
    }
}
