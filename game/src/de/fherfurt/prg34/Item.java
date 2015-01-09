package de.fherfurt.prg34;

/**
 * The items contained in the world, the player is allowed to take them and/or use them.
 */

public class Item {
    public Item(String name, String description, Item correctlyUsedWithItem, Item correctUseResult, int xPos, int yPos, boolean outInTheWorld) {
        this.name = name;
        this.description = description;
        this.correctlyUsedWithItem = correctlyUsedWithItem;
        this.correctUseResult = correctUseResult;
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeX = 10;
        this.sizeY = 10;
    }

    public String getName() {
        return name;
    }

    /**
     * Delivers description of the object if player uses looksAt(item)
     * @return Description of the object to be shown on screen
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if 2 items match when used with each other and returns a resulting item in that case
     * @param item The item this.item is used with
     * @return The item that is returned if one used 2 matching items in the proper order
     */
	public Item useWithItem(Item item){
        Item result = null;
        if (item == this.correctlyUsedWithItem){
            result = this.correctUseResult;
            //perhaps remove the 2 used items from inventory of the player, but how to manage that from here?
        }
        return result;
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

    public boolean isOutInTheWorld() {
        return outInTheWorld;
    }

    public void setOutInTheWorld(boolean outInTheWorld) {
        this.outInTheWorld = outInTheWorld;
    }

    public void draw() {
    }

    private final String name;
    private final String description;         //is used by Player.lookAt(item)
    private final Item correctlyUsedWithItem;
    private final Item correctUseResult;
    private int xPos;              //position of the item in the world, marks upper left corner
    private int yPos;
    private final int sizeX;
    private final int sizeY;
    private boolean outInTheWorld;  //marks if item is placed out in the world (and need to be drawn), otherwise no need to draw it
                                    // otherwise = stored in inventory, in an object like a chest, or in possession of a character
    //bufferedImage     //to be implemented later
}
