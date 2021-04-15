package org.neuedu.ch面向对象.多态.practice03;

public class Test {
    public static void main(String[] args) {
        TrainStation ts = new TrainStation();

        Student s = new Student();
        Teacher t = new Teacher();
        Worker w = new Worker();
        ZuiFan z = new ZuiFan();

        ts.saleTicket(s);
        ts.saleTicket(t);
        ts.saleTicket(w);
        ts.saleTicket(z);
    }
}
