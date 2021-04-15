package org.neuedu.ch面向对象.多态.practice02;

public class Test {
    public static void main(String[] args) {
        TrainStation station = new NewStatation();
        Student s = new Student();
        Teacher t = new Teacher();
        Worker w = new Worker();
        ZuiFan z = new ZuiFan();

        station.saleTicket(s);
        station.saleTicket(t);
        station.saleTicket(w);
        station.saleTicket(z);
    }
}
