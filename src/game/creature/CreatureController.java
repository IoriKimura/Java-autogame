package game.creature;

public class CreatureController implements Runnable{
    @Override
    public void run() {

    }

    Creature creature;

    public CreatureController(Creature creature){
        this.creature = creature;
    }


}
