package de.fherfurt.prg34;

/**
 * The items contained in the world, the player is allowed to take them and/or use them.
 */

public class Item {
    public Item(String name, String description, Item correctlyUsedWith, Item correctUseResult, int xPos, int yPos) {
        this.name = name;
        this.description = description;
        this.correctlyUsedWith = correctlyUsedWith;
        this.correctUseResult = correctUseResult;
        this.xPos = xPos;
        this.yPos = yPos;
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


	public Item useItemWith(Item item){
        Item result = null;
        if (item == this.correctlyUsedWith){
            result = this.correctUseResult;
            //perhaps remove the 2 used items from inventory of the player, but how to manage that from here?
        }
        return result;
    }


    public void draw() {
    }

    private String name;
    private String description;         //is used by Player.lookAt(item)
    private Item correctlyUsedWith;
    private Item correctUseResult;
    private int xPos;
    private int yPos;

    //bufferedImage
}
