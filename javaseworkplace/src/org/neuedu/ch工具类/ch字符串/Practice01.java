package org.neuedu.ch工具类.ch字符串;

public class Practice01 {

    public void checkMail(String email){
        // 1. 必须包含 @ 和 .
        if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
            System.out.println("必须包含 @ 和 .");
        }
        // 2. 最多有一个 @ 和 .
        else if (email.indexOf("@") != email.lastIndexOf("@") || email.indexOf(".") != email.lastIndexOf(".")) {
            System.out.println("最多有一个 @ 和 .");
        }
        // 3. @在.前面
        else if (email.indexOf("@") > email.indexOf(".")) {
            System.out.println("@ 必须在 . 前面");
        }
        else{
            System.out.println(email);
        }
    }
    public static void main(String[] args) {
        Practice01 practice01 = new Practice01();
        practice01.checkMail("sdfsfgdfgdfgq@@.qqcom");
    }
}
