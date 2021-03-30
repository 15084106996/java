package org.neuedu.ch类和对象.practice05;

public class Test {
    public static void main(String[] args) {
        // int byte short long 0
        // float double 0.0
        // boolean false
        // char space
        // 引用数据 ： null
        NoteBook noteBook1 = new NoteBook();
        noteBook1.showInfo();

        NoteBook noteBook2 = new NoteBook('红',666);
        noteBook2.showInfo();
    }
}
