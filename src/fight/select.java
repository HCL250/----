package fight;

import hero.Hero;
import hero.Soldier;

import java.util.Random;
import java.util.Scanner;

public class select {
    //实例化对象
    //实例化对象时 类名前面要加static(若在main函数内实例化则不需要static)
    //被static修饰的变量或方法只属于类本身,且被该类所有实例化对象所共享
    static Hero hero2 = new Hero("lancer", 500, 180, 100,10,0.60);
    static Hero hero1 = new Hero("saber", 500, 260, 100,12,0.65);
    static Soldier soldierA = new Soldier("SuperSoldier", 800, 120, 120);
    static Soldier soldierB = new Soldier("CasterMinion", 500, 90, 80);
    static Soldier soldierC = new Soldier("MeleeMinion", 650, 79, 50);


    public static void main(String[] args) {

        expand j=new Soldier();

        Scanner input = new Scanner(System.in);
        String hero;
        String soldier;
        System.out.println("请选择英雄:    (A:saber  B：lancer) ");
        hero = input.nextLine();
        //类名new一个新的对象 使switch-case中选择的hero和soldier能够在后面的战斗系统中被调用
        Hero switchHero;
        switch (hero) {
            case "A" -> {
                System.out.println("你选择的英雄为:" + hero1.show());
                switchHero = hero1;
            }
            case "B" -> {
                System.out.println("你选择的英雄为" + hero2.show());
                switchHero = hero2;
            }
            default -> throw new IllegalStateException("Unexpected value: " + hero);
        }
        System.out.println();
        System.out.println("请选择小兵  （A:超级兵 B：魔法小兵 C：近战小兵) ");
        soldier = input.nextLine();
        Soldier switchSoldier;
        switch (soldier) {
            case "A" -> {
                System.out.println("你选择的小兵为:" + soldierA.show());
                switchSoldier = soldierA;
            }
            case "B" -> {
                System.out.println("你选择的小兵为:" + soldierB.show());
                switchSoldier = soldierB;
            }
            case "C" -> {
                System.out.println("你选择的小兵为:" + soldierC.show());
                switchSoldier = soldierC;
            }
            default -> throw new IllegalStateException("Unexpected value: " + soldier);
        }


        if(hero.equals(soldier)) {
            //字符串之间的比较
            System.out.println("英雄和小兵不能相同,请重新选择小兵种类：");
            soldier= input.nextLine();//重新获取
        }

        //程序暂停
        Thread thread=new Thread();
        try {
            System.out.println("开始战斗");
            System.out.println("-----------------");
            thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战斗中");
        Random a=new Random();
        int order=a.nextInt(10000);
        int hurt;
        String dead = null;
        //英雄和小兵的战斗数值不能固定：加入躲闪 暴击
        while (switchSoldier.hp > 0 && switchHero.hp >0){
            switchHero.r=1/switchHero.r;
            hurt = switchHero.attack - switchSoldier.defense;
            if(order==10){
                hurt = switchHero.attack*(1/2)- switchSoldier.defense;
                System.out.println(switchHero.name+"虚弱,对小兵造成的伤害减半");
                if(Math.random()%3==0){
                    switchSoldier.hp=0;
                    System.out.print(switchSoldier.name);
                    //调用接口内的抽象方法
                    j.escape();
                    break;
                }
            }
            if(switchHero.r>1){
                hurt=0;
                System.out.println(switchHero.name+"的攻击被闪避");
            }
            switchSoldier.hp -= hurt;
            if (switchSoldier.hp <= 0) {
                switchSoldier.hp = 0;
                dead = switchSoldier.name;
            }
            System.out.println(switchSoldier.name + "的剩余血量为" + switchSoldier.hp);
            switchHero.hp -= switchSoldier.attack;
            if (switchHero.hp <= 0) {
                switchHero.hp = 0;
                dead = switchHero.name;
            }

            System.out.println(switchHero.name + "的剩余血量为" + switchHero.hp);
            if(switchHero.hp<200&&switchHero.blue>=6){
                System.out.println("英雄血量过低,是否要使用技能? (yes,no)");
                String choose = input.nextLine();
                if(choose=="yes"){
                    switchHero.skill();
                    switchHero.blue-=6;
                }
            }
        }

        System.out.println(dead + "已阵亡  游戏结束");
        System.out.println("-----------------------");
    }
}

