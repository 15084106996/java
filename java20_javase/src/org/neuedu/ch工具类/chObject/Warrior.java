package org.neuedu.ch工具类.chObject;

public class Warrior {
    private String name;
    private Weapon weapon;

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                '}';
    }

    public Warrior(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public Warrior() {
    }

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

    public static void main(String[] args) {
        Weapon w1 = new Weapon();
        w1.setName("方天画戟");
        w1.setDps(1);

        Warrior w = new Warrior("吕布",w1);
        System.out.println(w);
    }
}
