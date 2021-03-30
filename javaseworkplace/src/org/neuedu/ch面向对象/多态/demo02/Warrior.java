package org.neuedu.ch面向对象.多态.demo02;

public class Warrior {
    String name;

    public Warrior(String name) {
        this.name = name;
    }
    public Warrior() {}

    public void pk(Warrior warrior) {
        System.out.println(name+" 攻击了 "+warrior.name);
    }

    public void pk(Master master) {
        System.out.println(name+" 攻击了 "+master.name);
    }

    public static void main(String[] args) {
        Warrior w1 = new Warrior("盖伦");
        Warrior w2 = new Warrior("赵信");
        Master m1 = new Master("张海柱");

        w1.pk(w2);
        w1.pk(m1);
    }
}
