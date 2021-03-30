package org.neuedu.ch类和对象.demo07;

public class StudentTest {
    public static void main(String[] args) {
        Student s1=new Student("bob",90);
        Student s2=new Student("luck",88);
        Student[] sArr={s1,s2};
        System.out.println(sArr.length);
        for(int i=0;i< sArr.length;i++) {
            System.out.println(sArr[i].getName());
        }
        for (Student stu:sArr)
        {

        }
    }
}
