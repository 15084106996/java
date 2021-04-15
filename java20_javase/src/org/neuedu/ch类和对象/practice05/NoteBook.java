package org.neuedu.ch类和对象.practice05;

public class NoteBook {
    char color;
    int cpu;

    public NoteBook(char color, int cpu) {
        this.color = color;
        this.cpu = cpu;
    }

    public NoteBook() {}

    public void showInfo() {
        System.out.println(color+","+cpu);
    }
}
