package com.example;

public class Course {

    private String name;
    private int numberOfStudents;

    public Course(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
