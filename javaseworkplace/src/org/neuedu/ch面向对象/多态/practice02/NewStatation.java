package org.neuedu.ch面向对象.多态.practice02;

public class NewStatation extends TrainStation {
    @Override
    public void saleTicket(Person person) {
        if (person instanceof Student) {
            System.out.println(price*0.5);
        } else if (person instanceof Teacher) {
            System.out.println(price*0.9);
        } else if (person instanceof Worker) {
            System.out.println(price*0.7);
        } else if(person instanceof ZuiFan){
            System.out.println("打骨折");
        }else{
            System.out.println(price);
        }
    }
}
