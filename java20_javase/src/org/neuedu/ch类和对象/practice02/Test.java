package org.neuedu.ch类和对象.practice02;

public class Test {
    /**
     * 根据年龄进行降序排列
     * @param students
     */
    public void sort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            for (int j = 0; j < students.length - i; j++) {
                if (students[j].getAge() < students[j + 1].getAge()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("tom",12);
        Student s2 = new Student("bob",13);
        Student s3 = new Student("lucy",11);
        Student s4 = new Student("ella",16);
        Student s5 = new Student("mike",9);
        Student[] students = {s1,s2,s3,s4,s5};

        Test t = new Test();
        t.sort(students);

        for (Student student : students) {
            System.out.println(student.getName()+","+student.getAge());
        }
    }
}
