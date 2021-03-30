package org.neuedu.ch类和对象.demo05;

public class Warrior {
    //角色名称
    String name;
    //武器名字
    Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
