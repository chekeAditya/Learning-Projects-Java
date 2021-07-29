package com.example.notifyadapter;

public class Employee {
    private String name;
    private int salary;
    private int age;

    public Employee(String name, int salary, int age){
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public int getSalary(){
        return salary;
    }
}
