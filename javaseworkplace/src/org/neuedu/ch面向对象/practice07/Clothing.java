package org.neuedu.ch面向对象.practice07;

public class Clothing extends Goods implements VipPrice {
    String style;

    public Clothing(String style) {
        this.style = style;
    }

    public Clothing() {
    }

    @Override
    public void totalPrice() {
        System.out.println(unitPrice*account);
    }

    @Override
    public void reducedPrice() {
        System.out.println(unitPrice*account*DISCOUNT);
    }

    public void show() {
        System.out.println(style);
    }
}
