package org.neuedu.ch工具类.chObject;

public class Weapon {
    private String name;
    private int dps;

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", dps=" + dps +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }
}
