package org.neuedu.ch类和对象.practice07;

public class PersonCreate {
    public static void main(String[] args) {
        Person p1 = new Person("bob",20,1.77);
        Person p2 = new Person("yaoming",36,2.41);
        p1.sayHello();
        p2.sayHello();
    }
}
