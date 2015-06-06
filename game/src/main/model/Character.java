package main.model;

import java.util.ArrayList;

public class Character {

    public Character(String name, int xPos, int yPos, String imageFilename, int sizeX, int sizeY, ArrayList<String> sentences, ArrayList<Item> itemList) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.imageFilename = imageFilename;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.animationCounter = 0;
        this.sentences = sentences;
        this.itemList = new ArrayList<Item>(itemList);
    }

    /**
     * Delivers the answer of the character when the player talks to him
     * @return The answer of the character to be shown on screen
     */
    public ArrayList<String> getSentences() {
        return sentences;
    }

    /**
     * Handles transfer of item from player to this character
     * @param item The item that is transferred from player to this character
     */
    public void receiveItemFromPlayer(Item item){
        if ((item != null) && (!this.itemList.contains(item)))
            this.itemList.add(item);
    }

    /**
     * Handles transfer of item from character to player
     * @param item The item that is transferred from character to player
     * @return The item that is transferred so player can add it to his inventory
     */
    public Item giveItemToPlayer(Item item){
        this.itemList.remove(item);
        return item;
    }

    /**
     * Checks if item is in possession character
     * @param item The item to be checked
     * @return If item is in possession of character then return = true, else return = false
     */
    public boolean isPossessedByCharacter(Item item){
        return this.itemList.contains(item);
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

    public String getName(){
        return name;
    }

    private final String name;
    private int xPos;           //position of the character in the world, marks upper left corner
    private int yPos;
    private String imageFilename;
    private final int sizeX;
    private final int sizeY;
    private final int animationTime = 20;
    private int animationCounter;
    private int currentAnimationSequence;
    private ArrayList<String> sentences = new ArrayList<>();
    private ArrayList<Item> itemList;               //contains all items the character holds
}
