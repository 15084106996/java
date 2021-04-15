package org.neuedu.ch异常处理.demo01;

public class Demo01 {
    public void test() {
        System.out.println(123);
    }
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(arr[1]);// 越界
        int num = 0;
        System.out.println(5/0);// 数值
        System.out.println(100);
        Demo01 d = new Demo01();
        d = null;
        d.test();// java.lang.NullPointerException
    }
}
