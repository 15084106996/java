package org.neuedu.ch面向对象.多态.practice03;

public class TrainStation {
    double price = 100;

    public void saleTicket(Person person) {
        person.buyTicket(price);
    }
}
