package com.example.student;

public class Student {
    private String name;
    private int age;
    private String address;
    private String dob;
    private int imageId;

    public Student(String name, int age, String address, String dob, int imageId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.dob = dob;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public int getImageId() {
        return imageId;
    }
}
