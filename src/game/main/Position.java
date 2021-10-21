package game.main;

import game.creature.Player;

public class Position {

    private int x,y;
    static int mapSize = 3;
    static String[][] map = new String[mapSize][mapSize];
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



}
