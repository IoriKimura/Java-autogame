package game.creature;
import game.equipment.Armour;
import game.equipment.Equipment;
import game.equipment.Weapon;

import java.util.ArrayList;

public class Enemy extends Creature{
    public Weapon weapon;
    public Armour armour;
    public ArrayList<Equipment> equipments = new ArrayList<Equipment>(2);

    public Enemy(String name, int hp, int lvl, int atk, int exp, Weapon equipment1, Armour equipment2){
        super(name, hp, lvl, atk, exp);
        this.weapon = equipment1;
        this.armour = equipment2;
        equipments.add(weapon);
        equipments.add(armour);
    }

    public void showStats(){
        System.out.println("Enemy's name is " + getName() + "\n" + "Enemy's level is " + getLvl()
                + "\n" + "Enemy's personal power is " + getAtk()
                + "\n..........");
    }

    public void showInventory(){
        System.out.println("First slot: " + equipments.get(0).getName());
        System.out.println("Second slot: " + equipments.get(1).getName());
    }
}
