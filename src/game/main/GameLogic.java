package game.main;

import game.creature.CreatureController;
import game.creature.enemy;
import game.creature.Player;
import game.equipment.Armour;
import game.equipment.Weapon;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameLogic {
    static ArrayList<Weapon> wList = new ArrayList<Weapon>();
    static ArrayList<enemy> eList = new ArrayList<enemy>();
    static ArrayList<Armour> arList = new ArrayList<Armour>();
    static int enemyAmount = 3;
    static int fullDPS;
    static int mapSize = 4;
    static String[][] field = new String[mapSize][mapSize];
    static Boolean alive = true;

    static Player player;

    public static Boolean getAlive() {
        return alive;
    }

    public static void setAlive(Boolean alive) {
        GameLogic.alive = alive;
    }

    public static int getEnemyAmount() {
        return enemyAmount;
    }

    public static void setEnemyAmount(int enemyAmount) {
        GameLogic.enemyAmount = enemyAmount;
    }

    public static ArrayList<enemy> geteList() {
        return eList;
    }

    public static void seteList(enemy enemy) {
        GameLogic.eList.remove(enemy);
    }

    static void generation(){
        String[] wNames = {"Вылизанный меч смертельного испуга", "Кистень наставления на путь истины", "Меч леденящего душу взгляда",
                "Кортик", "Усиленный пернач", "Церемониальная булава", "Дубина переговоров", "Лук Амоса", "Средний охотничий нож", "Алая сабля смерти"};
        String[] eNames = {"Первый", "Второй", "Третий"};

        Random rnd = new Random();

        for (int i = 0; i < enemyAmount; i++)
        {
            wList.add(new Weapon(wNames[rnd.nextInt(wNames.length)], rnd.nextInt(20), rnd.nextInt(5), rnd.nextInt(300)));
            arList.add(new Armour(0,rnd.nextInt(5),rnd.nextInt(10)));
            eList.add(new enemy(eNames[rnd.nextInt(eNames.length)], rnd.nextInt(10), rnd.nextInt(5), rnd.nextInt(5), 0,
                    wList.get(rnd.nextInt(wList.size())), arList.get(rnd.nextInt(arList.size())), rnd.nextInt(mapSize), rnd.nextInt(mapSize)));

            System.out.println("..........");
            eList.get(i).showStats();
            eList.get(i).armour.showStats();
            eList.get(i).weapon.showStats();
        }
    }

    static void player(){
        Random rnd = new Random();
        player = new Player("Имир", rnd.nextInt(10), rnd.nextInt(5), rnd.nextInt(5), 100, arList.get(rnd.nextInt(arList.size())), wList.get(rnd.nextInt(wList.size())),
                mapSize, rnd.nextInt(mapSize), rnd.nextInt(mapSize));
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
        while(alive && enemyAmount != 0){
            player.walking();
            System.out.println("//////////");
            draw();
            makeThread();
            wait1();
            System.out.println("//////////");
        }
        es.shutdown();

    }

    public static void draw(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                field[i][j] = "0";
            }
        }
        field[player.getX()][player.getY()] = "\u001b[38;5;42m" + "@" + "\u001b[38;5;15m";
        for(int i = 0; i < eList.size(); i++){
            field[eList.get(i).getX()][eList.get(i).getY()] =  "\u001b[38;5;198m" + eList.get(i).getName().charAt(0) + "\u001b[38;5;15m";
        }
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    static ExecutorService es = Executors.newCachedThreadPool();
    static void makeThread(){
        for(int i = 0; i < eList.size(); i++){
            es.execute(new CreatureController(eList.get(i), player, i));
        }
    }

    static void wait1(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

