package game.creature;

import game.main.GameLogic;

import java.util.Random;

public class CreatureController implements Runnable {

    @Override
    public void run() {
        position();
        if(chekPostion() && !isFight)
            fight();
    }

    public enemy enemy;
    public Player player;
    public int mapSize = 3;
    public boolean isFight = false;

    public CreatureController(enemy enemy, Player player) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean chekPostion(){
        Boolean theSame = false;
        if (enemy.getY() == player.getY() && enemy.getX() == player.getX()) {
            enemy.showStats();
            theSame = true;
        }
        return theSame;
    }

    public void position(){
        Random rnd = new Random();

        if((enemy.getX() + 1) >= mapSize){
            enemy.setX(enemy.getX()-1);
        }
        if((enemy.getX() - 1) <= 0){
            enemy.setX(enemy.getX()+1);
        }

        if((enemy.getY()+1) >= mapSize){
            enemy.setY(enemy.getY()-1);
        }
        if((enemy.getY()-1) <= 0){
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
        GameLogic gl = new GameLogic();
        while(player.getHp() > 0){
            if(player.getHp() <= 0)
                System.out.println("You was killed... Bruh...");
                System.exit(0);
            if(enemy.getHp() <= 0) {
                System.out.println("Brutal! You smash him!");
                isFight = false;
                break;
            }

            while(enemy.getHp() > 0){
                enemy.setHp(gl.takeDMG(enemy.getHp(), gl.setFullDps(enemy.armour.getArmour(), player.weapon.getDamage(), player.getAtk())));
                if(enemy.getHp() <= 0) {
                    System.out.println("Brutal! You smash him!");
                    isFight = false;
                    break;
                }
                else
                    player.setHp(gl.takeDMG(player.getHp(), gl.setFullDps((player.armour.getArmour()),enemy.weapon.getDamage(), enemy.getAtk())));
                    if(player.getHp() <= 0) {
                        System.out.println("You was killed... Bruh...");
                        System.exit(0);
                    }
            }
        }
    }
}
