package org.neuedu.ch集合.demo10;

public class User {
    private int stuno;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "stuno=" + stuno +
                ", name='" + name + '\'' +
                '}';
    }

    public User(int stuno, String name) {
        this.stuno = stuno;
        this.name = name;
    }

    public User() {
    }

    public int getStuno() {
        return stuno;
    }

    public void setStuno(int stuno) {
        this.stuno = stuno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
