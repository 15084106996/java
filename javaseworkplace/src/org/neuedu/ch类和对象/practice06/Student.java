package org.neuedu.ch类和对象.practice06;

public class Student {
    // 设计一个类Student，该类包括姓名、学号和成绩。设计一个方法，按照成绩从高到低的顺序输出姓名、学号和成绩信息
    String name;
    int stuno;
    int grade;

    public Student(String name, int stuno, int grade) {
        this.name = name;
        this.stuno = stuno;
        this.grade = grade;
    }

    public static void main(String[] args) {
        Student s1 = new Student("bob",1001,66);
        Student s2 = new Student("tom",1003,56);
        Student s3 = new Student("lucy",1008,46);
        Student s4 = new Student("allen",1011,86);
        Student[] students = {s1, s2, s3, s4};
        s1.sort(students);
        for (Student student : students) {
            System.out.println(student.getName()+","+student.getStuno()+","+student.getGrade());
        }
    }

    public void sort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            for (int j = 0; j < students.length - i; j++) {
                if (students[j].getGrade() < students[j + 1].getGrade()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuno() {
        return stuno;
    }

    public void setStuno(int stuno) {
        this.stuno = stuno;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
