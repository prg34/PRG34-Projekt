package main.model;

/**
 * the Character controlled by the human player
 */
public class Player {
    public Player(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = 0;
        this.ySpeed = 0;
        this.sizeX = 20;
        this.sizeY = 20;
        this.inventory = new Inventory();
    }

    /**
     * updates the state of the player, e.g. his position and his current animation-frame
     */
    public void update() {
    }

    /**
     * Adds an item to the inventory the player just picked up or got form somewhere else
     * @param item The item the player just picked up
     */
    public void takeItem(Item item) {
        this.addItemToInventory(item);
    }

    /**
     * Handles the transfer of an item from player to a character
     * @param item The item the player gives to the character
     * @param character The character the player gives the item to
     */
    public void giveItemToCharacter(Item item, Character character) {
        character.receiveItemFromPlayer(item);
        this.inventory.removeItem(item);
    }

    /**
     * Handles the transfer of an item from a character to the player
     * @param item The item the player receives from the character
     * @param character The character who gives the item to the player
     */
    public void takeItemFromCharacter(Item item, Character character) {
        this.addItemToInventory(character.giveItemToPlayer(item));
    }

    /**
     * Delivers the answer of the character the player talks to
     * @param character The character the player talks to
     * @param num Tells which of the characters possible answers is used here
     * @return The answer of the character to be shown on screen
     */
    String talkTo(Character character, int num){
        return character.getSentence(num);
    }

    /**
     * Adds an item to the inventory of the player, e.g. after the player picked up an item or received one from a character
     * @param item Item to be added to the inventory
     */
    public void addItemToInventory(Item item) {
        this.inventory.addItem(item);
    }

    /**
     * Removes the item from the inventory of the player, e.g. after the player used an item or gave it to a character
     * @param item Item to be removed from inventory
     */
    public void removeItemFromInventory(Item item) {
        inventory.removeItem(item);
    }

    /**
     * Checks if item is already in inventory
     * @param item The item to be checked
     * @return If item is in inventory then return = true, else return = false
     */
    public boolean isInInventory(Item item){
        return this.inventory.isInInventory(item);
    }

    /**
     * Returns the size of the inventory, only necessary for unit tests so far
     * @return Size of inventory
     */
    public int getInventorySize(){
        return inventory.getInventorySize();
    }

    public int getyPos() {
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    private String name;        //name of the player
    private int xPos;           //position of the player in the world, marks upper left corner
    private int yPos;
    private double xSpeed;
    private double ySpeed;
    private final int sizeX;    //size of the player for collision detection etc.
    private final int sizeY;
    private Inventory inventory;
}