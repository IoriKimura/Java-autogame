package game.creature;
import game.main.GameLogic;
import java.util.Random;

public class CreatureController implements Runnable {

    public enemy enemy;
    public Player player;
    public int mapSize;
    public boolean isFight = false;
    public int index;

    @Override
    public void run() {
        position();
        if(chekPostion() && !isFight)
            fight();
    }

    public CreatureController(enemy enemy, Player player, int index, int mapSize) {
        this.player = player;
        this.enemy = enemy;
        this.index = index;
        this.mapSize = mapSize;
    }

    public boolean chekPostion(){
        boolean theSame = false;
        if (enemy.getY() == player.getY() && enemy.getX() == player.getX()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            theSame = true;
        }
        return theSame;
    }

    public void position(){
        Random rnd = new Random();

        if(enemy.getX()+1 >= mapSize){
            enemy.setX(enemy.getX()-1);
        }
        if(enemy.getX()-1 <= 0){
            enemy.setX(enemy.getX()+1);
        }

        if(enemy.getY()+1 >= mapSize){
            enemy.setY(enemy.getY()-1);
        }
        if(enemy.getY()-1 <= 0){
            enemy.setY(enemy.getY()+1);
        }

        if(rnd.nextBoolean()){
            enemy.setX(enemy.getX()+1);
        }else{
            enemy.setX(enemy.getX()-1);
        }
        if(rnd.nextBoolean()){
            enemy.setY(enemy.getY()+1);
        }else{
          enemy.setY(enemy.getY()-1);
        }
    }

    public void fight(){
        isFight = true;
        System.out.println("YOUR ENEMY IS " + enemy.getName());
        while(player.getHp() > 0){
            if(player.getHp() == 0) {
                System.out.println(enemy.getName() + " killed you!");
                GameLogic.setAlive(false);
                break;
            }
            if(enemy.getHp() <= 0) {
                enemy.setHp(0);
                System.out.println("Brutal! You smash him!");
                GameLogic.pickUp(enemy.getWeapon(), enemy.getArmour());
                isFight = false;
                break;
            }

            while(enemy.getHp() > 0){
                enemy.setHp(GameLogic.takeDMG(enemy.getHp(), GameLogic.setFullDps(enemy.armour.getArmour(), player.weapon.getDamage(), player.getAtk())));
                if(enemy.getHp() <= 0) {
                    enemy.setHp(0);
                    System.out.println("Brutal! You smash him!");
                    GameLogic.pickUp(enemy.getWeapon(), enemy.getArmour());
                    isFight = false;
                    break;
                }
                else
                    player.setHp(GameLogic.takeDMG(player.getHp(), GameLogic.setFullDps((player.armour.getArmour()),enemy.weapon.getDamage(), enemy.getAtk())));
                    if(player.getHp() <= 0) {
                        System.out.println("You was killed... Bruh...");
                        player.setHp(0);
                        GameLogic.setAlive(false);
                        break;
                    }
            }
        }
        GameLogic.setEnemyAmount(GameLogic.getEnemyAmount()-1);
        GameLogic.seteList(enemy);
    }
}
