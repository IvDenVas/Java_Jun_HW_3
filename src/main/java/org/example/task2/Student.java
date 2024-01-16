package org.example.task2;

public class Student{
    public String name;
    public int age;
    transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return name + " " + age + " " + GPA;
    }
}
