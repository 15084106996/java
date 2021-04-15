package org.neuedu.ch面向对象.practice13;

public class SalariedEmployee extends ColaEmployee {
    double sal;
    @Override
    public double getSalary(int month) {
        if (month == this.month) {
            sal = sal + 100;
        }
        return sal;
    }
}
