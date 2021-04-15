package org.neuedu.ch面向对象.practice13;

public class HourlyEmployee extends ColaEmployee {
    double perMoney;
    double hours;
    @Override
    public double getSalary(int month) {
        double total = 0;
        if (hours <= 160) {
            total = perMoney * hours;
        }else{
            total = (hours - 160) * 1.5 * perMoney + 160 * perMoney;
        }
        if (month == this.month) {
            total += 100;
        }
        return total;
    }
}
