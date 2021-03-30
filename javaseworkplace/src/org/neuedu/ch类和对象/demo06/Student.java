package org.neuedu.ch类和对象.demo06;

public class Student {
    String name;
    int age;

    public Student getStu() {
        Student s = new Student("bob", 33);
        return s;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
