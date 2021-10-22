package game.main;

import game.creature.enemy;
import game.creature.Player;
import game.equipment.Armour;
import game.equipment.Weapon;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    static  ArrayList<Weapon> wList = new ArrayList<Weapon>();
    static ArrayList<enemy> eList = new ArrayList<enemy>();
    static ArrayList<Armour> arList = new ArrayList<Armour>();
    static int enemyAmount = 3;
    static int fullDPS;

    static Player player;


    static void generation(){
        String[] wNames = {"Вылизанный меч смертельного испуга", "Кистень наставления на путь истины", "Меч леденящего душу взгляда",
                "Кортик", "Усиленный пернач", "Церемониальная булава", "Дубина переговоров", "Лук Амоса", "Средний охотничий нож", "Алая сабля смерти"};
        String[] eNames = {"One", "Two", "Three"};

        Random rnd = new Random();

        for (int i = 0; i < enemyAmount; i++)
        {
            wList.add(new Weapon(wNames[rnd.nextInt(wNames.length)], rnd.nextInt(20), rnd.nextInt(5), rnd.nextInt(300)));
            arList.add(new Armour(0,rnd.nextInt(5),rnd.nextInt(10)));
            eList.add(new enemy(eNames[rnd.nextInt(eNames.length)], rnd.nextInt(10), rnd.nextInt(5), rnd.nextInt(5), 0, wList.get(rnd.nextInt(wList.size())), arList.get(rnd.nextInt(arList.size()))));

            System.out.println("..........");
            eList.get(i).showStats();
            eList.get(i).armour.showStats();
            eList.get(i).weapon.showStats();
        }
    }

    static void player(){
        Random rnd = new Random();
        player = new Player("Имир", rnd.nextInt(10), rnd.nextInt(5), rnd.nextInt(5), 100, arList.get(rnd.nextInt(arList.size())), wList.get(rnd.nextInt(wList.size())));
        System.out.println("..........");
        player.showStats();
        player.armour.showStats();
        player.weapon.showStats();
    }

    public static int setFullDps(int ARM, int DMG, int ATK){
        fullDPS = (DMG + ATK) - ARM;
        return fullDPS;
    }

    public static int takeDMG(int hp, int dmg){
        hp-= dmg;
        return hp;
    }

    static void game(){
        generation();
        player();
    }


}

