package main.model;

/**
 * The objects contained in the world (like trees, fences, doors, houses etc.), with some the user is able to interact
 */

public class Object {
    public Object(String name, int xPos, int yPos, Item openedWithItem, Item content) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeX = 20;
        this.sizeY = 20;
        this.opened = false;
        this.openedWithItem = openedWithItem;
        this.content = content;
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

    /**
     * Uses an item with an object to try to open it, if they match the object opens (door, chest), and gives back its contents (if object is a chest)
     * @param item The item that is used to try to open the object
     * @return The item that is given back if object is a chest
     */
    public Item useItemToOpen(Item item){
        Item result = null;
        if (item == this.openedWithItem){
            open();
            result = this.content;
        }
        return result;
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
    private int xPos;           //position of the object in the world, marks upper left corner
    private int yPos;
    private final int sizeX;
    private final int sizeY;
    private boolean opened;      // shows if the object ist opened or closed, like chests or doors, default value closed
    private Item openedWithItem;    //proper item, like a key, to open a door or a chest
    private Item content;          //if chest was opened, content of it is returned

    //bufferedImage
}