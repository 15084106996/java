package org.neuedu.ch面向对象.test接口.practice01;

public class Test {
    public static void main(String[] args) {
        News s = new Sports();
        News y = new Yule();
        News z = new Zhengzhi();

        s.publishNews();
        y.publishNews();
        z.publishNews();
    }
}
