package org.neuedu.ch面向对象.多态.practice05;

public class Parking {
    public void getMoney(Vehicle vehicle) {
        double total = vehicle.payMoney();
        System.out.println(total);
    }
}
