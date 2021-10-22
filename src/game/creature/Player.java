package game.creature;

import game.equipment.Armour;
import game.equipment.Weapon;

import java.util.Random;

public class Player extends Creature{
    public Weapon weapon;
    public Armour armour;
    public int mapSize;

    private int x,y;
    //Getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    //Setters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Player(String name, int hp, int lvl, int atk, int exp, Armour armour, Weapon weapon, int mapSize, int x, int y){
        super(name, hp, lvl, atk, exp);
        this.armour = armour;
        this.weapon = weapon;
        Random rnd = new Random();
        this.mapSize = mapSize;
        this.x = x;
        this.y = y;
    }

    public void showStats(){
        System.out.println("Your name is " + getName() + " || " + "Your level is " + getLvl()
                + " || " + "You have " + getExp() + " experience"
                + " || " + "Your personal power is " + getAtk());
    }

    public void walking(){
        Random rnd = new Random();

        if(getX()+1 >= mapSize){
            setX(getX()-1);
        }
        if(getX()-1 <= 0){
            setX(getX()+1);
        }

        if(getY()+1 >= mapSize){
            setY(getY()-1);
        }
        if(getY()-1 <= 0){
            setY(getY()+1);
        }

        if(rnd.nextBoolean()){
            setX(getX()+1);
        }else{
            setX(getX()-1);
        }
        if(rnd.nextBoolean()){
            setY(getY()+1);
        }else{
            setY(getY()-1);
        }
    }
}
