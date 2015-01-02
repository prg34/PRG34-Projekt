package de.fherfurt.prg34;

/**
 * The items contained in the world, the player is allowed to take them and/or use them.
 */

public class Item {
    public Item(String name, String description, String correctlyUsedWith, String correctUseResult, int xPos, int yPos) {
        this.name = name;
        this.description = description;
        this.correctlyUsedWith = correctlyUsedWith;
        this.correctUseResult = correctUseResult;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String getDescription() {
        return description;
    }

    public void draw() {
    }

    private String name;
    private String description;  //will be used for player.lookAt(item)
    private String correctlyUsedWith;
    private String correctUseResult;
    private int xPos;
    private int yPos;

    //bufferedImage

    //useItem()  //replaced by correcltyUSedWith/correctUseResult
}
