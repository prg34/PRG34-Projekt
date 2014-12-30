package de.fherfurt.prg34;

/**
 * The items contained in the world, the player is allowed to take them and/or use them.
 */

public class Item {
    public Item(String name, String correctlyUsedWith, String correctUseResult, int xPos, int yPos) {
        this.correctlyUsedWith = correctlyUsedWith;
        this.correctUseResult = correctUseResult;
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void draw() {
    }

    private String correctlyUsedWith;
    private String correctUseResult;
    private String name;
    private int xPos;
    private int yPos;

    //bufferedImage

    //useItem() "ersetzt" durch correcltyUSedWith/correctUseResult
}