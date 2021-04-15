package org.neuedu.ch面向对象.practice06;

public class Student extends Person{
    int id;

    public Student(String name, boolean gender, int id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
