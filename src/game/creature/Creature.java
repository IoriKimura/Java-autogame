package game.creature;

public class Creature {
    private int hp, exp, lvl, atk;
    private String name = "Ordinary_Name";

    //Getters
    public int getHp(){
        return hp;
    }

    public int getAtk(){
        return atk;
    }

    public int getExp(){
        return exp;
    }

    public int getLvl(){
        return lvl;
    }

    public String getName(){
        return name;
    }

    //Setters
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Creature(String name, int hp, int lvl, int atk, int exp){
        this.name = name;
        this.hp = hp;
        this.lvl = lvl;
        this.atk = atk;
        this.exp = exp;
    }
}
