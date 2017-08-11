package com.example;

public class Course {

    private String name;
    private int numberOfStudents;

    public Course() {
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (numberOfStudents != course.numberOfStudents || !name.equals(course.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return numberOfStudents;
    }
}
