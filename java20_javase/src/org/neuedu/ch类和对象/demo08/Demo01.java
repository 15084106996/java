package org.neuedu.ch类和对象.demo08;

public class Demo01 {
    // 全局变量（成员变量，对象属性）有默认值
    // 基本数据类型：数字 0
    // 引用数据类型：String null
    int num;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        Demo01 d1 = new Demo01();
        System.out.println(d1.getNum());// 0
        System.out.println(d1.getName());// null

        Demo01 d2 = new Demo01();
    }
}
