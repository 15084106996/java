package org.neuedu.ch面向对象.practice10;

public class Player2 {
    private static int s = 0;
    private Player2() { s++;}
    public static Player2 newplayer(){
        if (s >= 11) {
            System.out.println("只允许创建11个对象");
            return null;

        }
        System.out.println("创建了"+s+"个对象");
        return new Player2();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Player2.newplayer();
        }
    }

}
