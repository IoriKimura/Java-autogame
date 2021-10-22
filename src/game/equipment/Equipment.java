package game.equipment;

import java.util.ArrayList;

public class Equipment {
    private int lvlReq, damage, cost;
    private String name = "Ordinary_Equipment";
    //Getters
    public int getDamage() {
        return damage;
    }

    public int getLvlReq() {
        return lvlReq;
    }

    public String getName(){
        return name;
    }

    //Setters
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLvlReq(int lvlReq) {
        this.lvlReq = lvlReq;
    }

    public Equipment(String name, int damage, int lvlReq){
        this.name = name;
        this.damage = damage;
        this.lvlReq = lvlReq;
    }
}
