package org.neuedu.ch异常处理.demo02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Demo01 {
    public static void main(String[] args) {
        try {
            FileInputStream fs = new FileInputStream("D:\\test.txt");
            Class.forName("aaa");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(100);
    }
}
