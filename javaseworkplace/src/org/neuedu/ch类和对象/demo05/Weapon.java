package org.neuedu.ch类和对象.demo05;

public class Weapon {
    String name;
    int dps;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Weapon() {
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public void setName(String name) {
        this.name = name;
    }
}
