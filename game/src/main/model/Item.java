package main.model;

/**
 * The items contained in the world, the player is allowed to take them and/or use them.
 */

public class Item {
    public Item(String name, String description, int xPos, int yPos, String ImageFilename, int sizeX, int sizeY, Item correctlyUsedWithItem, Item correctUseResult) {
        this.name = name;
        this.description = description;
        this.xPos = xPos;
        this.yPos = yPos;
        this.ImageFilename = ImageFilename;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.correctlyUsedWithItem = correctlyUsedWithItem;
        this.correctUseResult = correctUseResult;
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

    public String getImageFilename(){
        return ImageFilename;
    }

    private final String name;
    private final String description;         //is used by Player.lookAt(item)
    private int xPos;                       //position of the item in the world, marks upper left corner
    private int yPos;
    private String ImageFilename;
    private final int sizeX;
    private final int sizeY;
    private final Item correctlyUsedWithItem;
    private final Item correctUseResult;
}
