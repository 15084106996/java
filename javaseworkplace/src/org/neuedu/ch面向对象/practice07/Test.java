package org.neuedu.ch面向对象.practice07;

public class Test {
    public static void main(String[] args) {
        Clothing clothing = new Clothing("秋款");
        clothing.account = 10;
        clothing.unitPrice = 50;
//        clothing.style = "秋款";


        clothing.show();
        clothing.totalPrice();
        clothing.reducedPrice();
    }
}
