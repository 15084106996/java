package org.neuedu.ch异常处理.demo05;

public class Person {
    private int head;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        if (head != 1) {
            // 抛一个异常，HeadCountsException
            try {
                throw new HeadCountsException();
            } catch (HeadCountsException e) {
                e.printStackTrace();
            }
        }
        this.head = head;
    }
}
