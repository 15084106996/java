package org.neuedu.ch类和对象.demo05;

public class Warrior {
    // 角色名称
    String name;
    // 武器（名字，攻击力）
    Weapon weapon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
