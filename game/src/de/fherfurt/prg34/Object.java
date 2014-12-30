package de.fherfurt.prg34;

/**
 * The objects contained in the world, also not usable ones.
 */

public class Object {
    public Object(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        sizeX = 20;
        sizeY = 20;
    }

    public void draw() {
    }

    private String name;
    private int xPos;
    private int yPos;
    private int sizeX;
    private int sizeY;

    //bufferedImage
}