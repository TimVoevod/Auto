package com.company;

public class Example {

    public static void main(String[] args) {
        Person person = new Person();
        String a = person.getName();
        System.out.println(a);
        Student student = new Student();
        a = student.getName();
        System.out.println(a);
        student.setLesson("English");
        a = student.getLesson();
        System.out.println(a);
    }
}
