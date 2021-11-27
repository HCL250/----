package hero;

import java.util.Random;

//Hero子类
public class Hero extends Soldier {
    public double r;
    public int blue;
    public String skill;

    public Hero(String name, int hp, int attack, int defense,int blue,double r) {
        super(name, hp, attack,defense);
        this.r=r;
        this.blue=blue;
    }


    //重写父类Soldier的show方法
    @Override
    public String show() {
        return "名称:" + name + " 生命值:" + hp + " 攻击力:" + attack + " 防御力:" + defense +"蓝"+blue+" 几率虚弱"+r;
    }

    public void skill(){
        attack=attack*2;
        defense=defense*(1/3);
        System.out.println("使用技能,攻击力翻倍,同时防御力削弱一半,当前攻击力为"+attack+"当前防御力为"+defense);
        }
    }




