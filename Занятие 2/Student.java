package com.company;

public class Student extends Person {
    public String teacher = "Petrov";
    public String lesson = "Math";


    void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    private String getTeacher() {
        return teacher;
    }

    protected String getLesson() {
        return lesson;
    }
}
