package org.neuedu.ch类和对象.practice02;
//降序

public class Text {

    public void sort(Student[] s) {
        Student s1=new Student();
        for (int i=0;i<s.length-1;i++){
            for (int j=i+1;j<s.length;j++) {
                if (s[i].math<s[j].math) {
                    s1=s[i];
                    s[i]=s[j];
                    s[j]=s1;
                }
            }
         }
    }
    public static void main(String[] args) {
        Student s1 = new Student("tom", 12);
        Student s2 = new Student("bob", 13);
        Student s3 = new Student("lucy", 11);
        Student s4 = new Student("ella", 16);
        Student s5 = new Student("mike", 9);
        Student[] s = {s1, s2, s3, s4, s5};
        Text t=new Text();
        t.sort(s);
        for (Student student:s)
        {
            System.out.println(student.getName()+","+student.getMath());
        }
    }




}
