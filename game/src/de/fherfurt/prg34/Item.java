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
     * Returns the description of the item to be shown on the screen when player looks at that item
     * @return The description of the item
     */
    public String lookAt(){
        return this.description;
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

    /**
     * Indicates if item is placed somewhere out in the world (only then it is drawn in the world)
     * @return If item is placed somewhere out in the world return = true, else return = false
     */
    public boolean isOutInTheWorld() {
        return outInTheWorld;
    }

    /**
     * outInTheWorld needs to be updated if item is picked up etc.
     * @param outInTheWorld new value for outInTheWorld
     */
    public void setOutInTheWorld(boolean outInTheWorld) {
        this.outInTheWorld = outInTheWorld;
    }

    /**
     * used to draw the item on the screen, only dummy method so far
     */
    public void draw() {
    }

    private final String name;
    private final String description;         //is used by Player.lookAt(item)
    private final Item correctlyUsedWithItem;
    private final Item correctUseResult;
    private int xPos;                       //position of the item in the world, marks upper left corner
    private int yPos;
    private final int sizeX;
    private final int sizeY;
    private boolean outInTheWorld;      //marks if item is placed out in the world (and need to be drawn), otherwise no need to draw it
                                        // otherwise = stored in inventory, in an object like a chest, or in possession of a character
}
