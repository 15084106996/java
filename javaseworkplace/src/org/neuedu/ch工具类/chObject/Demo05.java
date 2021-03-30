package org.neuedu.ch工具类.chObject;

public class Demo05 {
    private String name;
    private int age;

    public Demo05(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Demo05() {
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

    @Override
    public String toString() {
        return "Demo05{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Demo05 d1 = new Demo05("tom",12);
        Demo05 d2 = new Demo05("lucy",22);

        System.out.println(d1);
    }
}
