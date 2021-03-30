package org.neuedu.ch面向对象.practice13;

public class TestCompany {
    public static void main(String[] args) {
        HourlyEmployee h = new HourlyEmployee();
        h.name = "tom";
        h.hours = 220;
        h.perMoney = 50;
        h.month = 2;

        SalesEmployee s = new SalesEmployee();
        s.tc = 0.1;
        s.month = 3;
        s.name = "lucy";
        s.yxse = 200000;

        SalariedEmployee se = new SalariedEmployee();
        se.name = "bob";
        se.sal = 8000;
        se.month = 5;

        ColaEmployee[]  colaEmployees = {h,s,se};

        Company c = new Company();

        for (ColaEmployee colaEmployee : colaEmployees) {
            c.showInfo(colaEmployee,5);
        }
    }
}
