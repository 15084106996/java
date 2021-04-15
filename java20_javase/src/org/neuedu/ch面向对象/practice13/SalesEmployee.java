package org.neuedu.ch面向对象.practice13;

public class SalesEmployee extends ColaEmployee{
    double yxse;
    double tc;
    @Override
    public double getSalary(int month) {
        double total = yxse * tc;
        if (month == this.month) {
            total += 100;
        }
        return total;
    }
}
