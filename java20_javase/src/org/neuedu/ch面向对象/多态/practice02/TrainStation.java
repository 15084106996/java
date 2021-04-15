package org.neuedu.ch面向对象.多态.practice02;

public class TrainStation {
    double price = 100;

    public void saleTicket(Person person) {
        if (person instanceof Student) {
            System.out.println(price*0.5);
        } else if (person instanceof Teacher) {
            System.out.println(price*0.9);
        } else if (person instanceof Worker) {
            System.out.println(price*0.7);
        } else{
            System.out.println(price);
        }
    }
}
