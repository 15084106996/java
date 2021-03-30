package org.neuedu.ch类和对象.practice02;

public class Student {
    String name;
    int math;

    public Student() {
    }

    public Student(String name, int math) {
        this.name = name;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
}
