package org.neuedu.ch面向对象.practice13;

public class Company {
    public void showInfo(ColaEmployee employee,int month) {
        double total = employee.getSalary(month);
        System.out.println(total);
    }
}
