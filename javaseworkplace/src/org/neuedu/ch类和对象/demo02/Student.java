package org.neuedu.ch类和对象.demo02;

public class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pk(Student s) {
        System.out.println(name + "揍了" + s.getName());
    }
}
