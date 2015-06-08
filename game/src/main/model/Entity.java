package main.model;

/**
 *
 */
public class Entity {
    public Entity(String name, int xPos, int yPos, int sizeX, int sizeY, String imageFilename)
    {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.imageFilename = imageFilename;
    }

    public String getName(){
        return name;
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

    public String getImageFilename(){
        return imageFilename;
    }

    private final String name;
    private int xPos;           //position of the character in the world, marks upper left corner
    private int yPos;
    private final int sizeX;
    private final int sizeY;
    private String imageFilename;
}
