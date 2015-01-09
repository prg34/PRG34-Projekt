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

    /**
     * Used if player opens an object, e.g. a door or a chest
     * changes state of the object
     */
    public void open() {
        this.opened = true;
    }

    /**
     * Used if player closes an object, e.g. a door or a chest
     * changes state of the object
     */
    public void close() {
        this.opened = false;
    }

    public void draw() {
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    private final String name;
    private int xPos;
    private int yPos;
    private final int sizeX;
    private final int sizeY;
    private boolean opened;  // shows if the object ist opened or closed, like chests or doors, default value closed

    //bufferedImage
}