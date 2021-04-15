package org.neuedu.ch面向对象.practice01;

public class Employee extends Person {
    double sal;
    double year;

    @Override
    public void show() {
        System.out.println("class Employee "+name);
    }

    public double addSal() {
        if (year > 1) {
            sal = sal * 1.1;
        }
        return sal;
    }

    public double addSal(double addMoney) {
        if (year > 1) {
            if (addMoney > sal * 0.5) {
                sal = sal * 1.5;
            }
            else{
                sal = sal + addMoney;
            }
        }
        return sal;
    }
}
