package game.creature;

import game.equipment.Armour;
import game.equipment.Weapon;

public class Player extends Creature{
    public Weapon weapon;
    public Armour armour;

    public Player(String name, int hp, int lvl, int atk, int exp, Armour armour, Weapon weapon){
        super(name, hp, lvl, atk, exp);
        this.armour = armour;
        this.weapon = weapon;
    }

    public void showStats(){
        System.out.println("Your name is " + getName() + "\n" + "Your level is " + getLvl()
                + "\n" + "You have " + getExp() + " experience"
                + "\n" + "Your personal power is " + getAtk()
                + "\n..........");
    }
}
