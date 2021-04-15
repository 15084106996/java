package org.neuedu.ch面向对象.practice10;

public class Player {
    private static int count = 0;
    private Player() {
        count++;
    }
    public static Player createPlayer() {
        if (count >= 11) {
            System.out.println("已经创建11个了");
            return null;
        }
        System.out.println("创建了一个对象");
        Player player = new Player();
        return player;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Player.createPlayer();
        }
    }
}
