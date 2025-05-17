package dev.shen.java.basic.classes.interfaces;

// Class implementing multiple interfaces
public class GameCharacter implements Movable, Resizable {
    private double posX;
    private double posY;
    private double size;

    public GameCharacter(double posX, double posY, double size) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
    }

    @Override
    public void move(double x, double y) {
        this.posX += x;
        this.posY += y;
        System.out.println("Character moved to position (" + posX + "," + posY + ")");
    }

    @Override
    public void resize(double factor) {
        this.size *= factor;
        System.out.println("Character resized to " + size);
    }

    @Override
    public String toString() {
        return "GameCharacter [posX=" + posX + ", posY=" + posY + "; Factor: " + size + "]" ;
    }


    public static void main(String[] args) {
        GameCharacter gameCharacter = new GameCharacter(50, 50, 50);
        System.out.println(gameCharacter);
        gameCharacter.resize(2);
        gameCharacter.move(-50, -50);
        System.out.println(gameCharacter);
    }
}
