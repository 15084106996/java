package org.neuedu.ch面向对象.practice06;

public class Person {
    String name;
    boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Person(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    public Person() {
    }
}
