package com.example.fragmentcommunication;

import java.io.Serializable;

public class Model implements Serializable {

    private String name;
    private String grade;
    private String  percentage;
    private int age;

    public Model(String name, String grade, String percentage, int age) {
        this.name = name;
        this.grade = grade;
        this.percentage = percentage;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String  getPercentage() {
        return percentage;
    }

    public int getAge() {
        return age;
    }
}
