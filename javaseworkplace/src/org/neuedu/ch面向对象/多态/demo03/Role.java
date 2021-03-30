package org.neuedu.ch面向对象.多态.demo03;

public class Role {
    String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pk(Role r){
        System.out.println(name+" 攻击了 "+r.name);
    }
}
