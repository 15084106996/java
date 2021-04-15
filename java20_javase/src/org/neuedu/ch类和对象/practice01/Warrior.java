package org.neuedu.ch类和对象.practice01;

/**
 * 战士类
 */
public class Warrior {
    String name;// 角色名称
    int level;// 等级
    int hp;// 血量
    int dps;// 攻击力
    int defend;// 防御

    public void levelUp(double money) {
        int level = (int)(money / 1000);
        this.level = this.level + level;
        this.dps = this.dps + level * 8;
        this.defend = this.defend + level * 3;
        System.out.println(name+" 升级了，能力提升");
    }

    /**
     * 攻击
     * @param w 被攻击的对象
     */
    public void attack(Warrior w) {
        if (hp == 0) {
            System.out.println("您的角色已经阵亡，不能攻击");
        }else{
            if (w.getHp() == 0) {
                System.out.println(w.getName()+" 已经阵亡，不能再攻击他了");
            }else{
                // 造成的伤害
                int damage = dps - w.getDefend();
                if (damage <= 0) {
                    damage = 1;
                }
                // 修改血量
                int restHp = w.getHp() - damage;
                if (restHp <= 0) {
                    w.setHp(0);
                    System.out.println(w.getName()+" 已经阵亡");
                    return;
                }
                w.setHp(restHp);
                System.out.println(name+" 对 "+w.getName()+" 造成了 "+damage+" 伤害,对方还有 "+w.getHp()+" 血量");
            }
        }
    }

    public Warrior(String name) {
        this.name = name;
        this.level = 1;
        this.hp = 100;
        this.dps = 10;
        this.defend = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }
}
