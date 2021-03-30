package org.neuedu.ch集合.demo07;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * @param o1
     * @param o2
     * @return 负数 o2 > o1 正数 o1 > o2 0 相等
     */
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
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
