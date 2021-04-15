package org.neuedu.ch类和对象.demo07;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("bob",99);
        Student s2 = new Student("lucy",88);
        Student[] sArr = {s1,s2};
        System.out.println(sArr.length);// 2

        // 打印出数组中每一个学生的名字
        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i].getName());
        }

        for (Student stu : sArr) {
            System.out.println(stu.getName());
        }

//        int[] arr = {4, 3, 2, 1};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        for (int num : arr) {
//            System.out.println(num);
//        }
    }
}
