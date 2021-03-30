package org.neuedu.ch工具类.chObject;

public class Demo01 {
    public static void test(Object o) {

    }
    public static void main(String[] args) {
        String str = "hello";
        Object[] arr = {1, "2", false, new Demo01()};
        test(1);
        test("1");
        test(true);
        test(new Demo01());
    }

}
