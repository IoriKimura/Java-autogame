package game.equipment;

public class Weapon extends Equipment{
    private int cost;
    public Weapon(String name, int dmg, int lvlReq, int cost) {
        super(name, dmg, lvlReq);
        this.cost = cost;
    }
    //Costs' getter
    public int getCost() {
        return cost;
    }
    //Costs' setter
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void showStats(){
        System.out.println("Weapon: " + getName() + " || " + "Damage: " + getDamage()
                + " || " + "Level: " + getLvlReq()
                + " || " + "Cost: " + getCost());
    }
}
