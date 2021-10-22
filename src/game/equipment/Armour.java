package game.equipment;

public class Armour extends Equipment{
    private int armour;
    //Armour's getter
    public int getArmour() {
        return armour;
    }
    //Armour's setter
    public void setArmour(int armour) {
        this.armour = armour;
    }

    public Armour(int dmg, int lvlReq, int armour){
        super("Shield", dmg, lvlReq);
        this.armour = armour;
    }

    public void showStats(){
        System.out.println("Armour's name: " + getName() + " || " + "Power: " + getArmour()
                + " || " + "Level: " + getLvlReq());
    }
}
