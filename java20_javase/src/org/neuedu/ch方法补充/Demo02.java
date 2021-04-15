package org.neuedu.ch方法补充;

public class Demo02 {
    // 2  3  4  1  5
    // 1j 2j 2c 3j 3c 4j 4c 1c 5j 5c
    public void test1() {
        test2();
        test3();
        test4();
    }
    public void test2() {}
    public void test3() {}
    public void test4() {}
    public void test5() {}

    public static void main(String[] args) {
        Demo02 d = new Demo02();
        d.test1();
        d.test5();
    }
}
