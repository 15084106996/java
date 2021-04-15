package org.neuedu.ch面向对象.多态.demo05;

public class Role {
    public void pk(Role r) {
        if (r instanceof Master) {
            System.out.println("攻击法师");
            Master m = (Master)r;
            m.showMp();
        }
        else{
            System.out.println("攻击战士");
        }
    }
}
