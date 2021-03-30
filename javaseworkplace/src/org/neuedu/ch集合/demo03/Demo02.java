package org.neuedu.ch集合.demo03;

import java.util.LinkedList;

public class Demo02 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.addFirst(0);
        list.addLast(4);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}
