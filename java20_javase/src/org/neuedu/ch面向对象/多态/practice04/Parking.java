package org.neuedu.ch面向对象.多态.practice04;

public class Parking {
    public void getMoney(Vehicle vehicle,double times) {
        double total = vehicle.payMoney(times);
        System.out.println(total);
    }
}
