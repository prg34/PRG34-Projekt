package de.fherfurt.prg34;

/**
 * The objects contained in the world, also not usable ones.
 */

public class Object {
    public Object(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeX = 20;
        this.sizeY = 20;
        this.opened = false;
    }

    public void open() {
        this.opened = true;
    }

    public void close() {
        this.opened = false;
    }

    public void draw() {
    }

    private String name;
    private int xPos;
    private int yPos;
    private int sizeX;
    private int sizeY;
    private boolean opened;  // shows if the object ist opened or closed, like chests or doors, default value closed

    //bufferedImage
}