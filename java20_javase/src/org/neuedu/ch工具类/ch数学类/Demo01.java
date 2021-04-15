package org.neuedu.ch工具类.ch数学类;

public class Demo01 {
    public static void main(String[] args) {
        // Math 静态方法
        // 随机数 [0,1)
        System.out.println(Math.random());
        // 向上取整
        System.out.println(Math.ceil(5.1));
        // 向下取整
        System.out.println(Math.floor(5.9));
        // 四舍五入
        System.out.println(Math.round(5.5));
        // 取绝对值
        System.out.println(Math.abs(-9.9));
        // 取两个之中较大的值
        System.out.println(Math.max(5,6));
        // 取两个之中较小的值
        System.out.println(Math.min(5,6));
    }
}
