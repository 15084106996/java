package org.neuedu.ch面向对象.statics.demo04;

public class Test {
    public static void main(String[] args) {
        Person.name2 = "tom";

        Person p1 = new Person();
        Person p2 = new Person();
        p1.name2 = "bob";
        p2.name2 = "lucy";
        p1.name1 = "bob";
        p2.name1 = "lucy";

        System.out.println(p1.name2);
        System.out.println(p1.name1);
    }
}
