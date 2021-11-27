package hero;

import fight.expand;

import java.util.Objects;

//父类Soldier(因为英雄源自于小兵)
public class Soldier implements expand {
    public String name;
    public int hp;
    public int attack;
    public int defense;

    //Soldier的无参构造方法
    public Soldier(){

    }

    //Soldier的构造函数（有参方法）
    public Soldier(String name,int hp,int attack, int defense){
        this.name=name;
        this.hp=hp;
        this.attack=attack;
        this.defense=defense;
    }

    //封装
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getHpp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp=hp;
    }

    public int getAttack(){
        return attack;
    }

    public void setAttack(int attack){
        this.attack=attack;
    }

    public int getDefense(){
        return defense;
    }

    public void setDefense(int defense){
        this.defense=defense;
    }
    public String show(){
        return "名称:"+name+" 生命值:"+hp+" 攻击力:"+attack+" 防御力:"+defense;
    }

    //重写逃跑方法
    @Override
    public void escape() {
        System.out.println("竟然逃跑了");
    }

    @Override
    public void skill() {
        System.out.println("小兵没有技能");
    }

}
