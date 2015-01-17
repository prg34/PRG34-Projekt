package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * contains and manages all objects in the game-world
 */
public class World {
    public World(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.player = null;
        this.itemList = new ArrayList<Item>();
        this.objectList = new ArrayList<Object>();
        this.characterList = new ArrayList<Character>();
    }

    /**
     * updates the state of the world, e.g. the position of the active sector
     */
    public void update() {
    }

    /**
     * draws the background (= landscape), only dummy method so far
     */
    public void drawBackground(){

    }

    /**
     * used to draw the world on the screen, called by class Frame
     * calls draw methods of all items, objects and characters it manages
     */
    public void draw() {
        drawBackground();
        for(Object object : objectList) {
            object.draw();
        }
        for(Item item : itemList) {
            if (item.isOutInTheWorld()) item.draw();
        }
        for(Character character : characterList) {
            character.draw();
        }
        player.draw();
    }

    /**
     * Sets the player reference to the actual player object
     * @param player The actual player that is used in this game
     */
    public void addPlayer(Player player){
        if (player != null)
            this.player = player;
    }

    /**
     * Adds an item to the world, used for initial creation of the world
     * @param item The Item that is to be added to the world
     */
    public void addItem(Item item) {
        if ((item != null) && (!this.itemList.contains(item))) {
            this.itemList.add(item);
            item.setOutInTheWorld(true);
        }
    }

    /**
     * Removes an item from the world, e.g. after the item was picked up by the player and added to his inventory
     * @param item The item to be removed from the world
     */
    public void removeItem(Item item) {
        if ((item != null) && (this.itemList.contains(item))) {
            this.itemList.remove(item);
            item.setOutInTheWorld(false);
        }
    }

    /**
     * Adds an object to the world, used for initial creation of the world
     * @param object The object that is to be added to the world
     */
    public void addObject(Object object) {
        if ((object != null) && (!this.objectList.contains(object)))
            this.objectList.add(object);
    }

    /**
     * Adds a character to the world, used for initial creation of the world
     * @param character The character that is to be added to the world
     */
    public void addCharacter(Character character) {
        if ((character != null) && (!this.characterList.contains(character)))
            this.characterList.add(character);
    }

    /**
     * Returns the size of the item list, only necessary for unit tests so far
     * @return Size of itemList
     */
    public int getSizeItemList(){
        return itemList.size();
    }

    /**
     * Checks for a collision between the player and all items, objects and characters in the world
     * @return Returns true if there was a collision between the player and anything else
     */
    public boolean checkForCollision(){
        for(Object object : objectList) {
            if (checkForCollisionWithObject(object)){
                return true;
            }
        }
        for(Character character : characterList) {
            if (checkForCollisionWithCharacter(character)){
                return true;
            }
        }
        for(Item item : itemList) {
            if (item.isOutInTheWorld() && checkForCollisionWithItem(item)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a collision between the player and an object (like a tree or a house)
     * @param object The object that might have collided with the player
     * @return Returns true if there was a collision between the player and the object
     */
    public boolean checkForCollisionWithObject(Object object){
        return this.player.getxPos() < object.getxPos() + object.getSizeX()       &&
                object.getxPos() < this.player.getxPos() + this.player.getSizeX() &&
                this.player.getyPos() < object.getyPos() + object.getSizeY()      &&
                object.getyPos() < this.player.getyPos() + this.player.getSizeY();
        }

    /**
     * Checks for a collision between the player and a character
     * @param character The character that might have collided with the player
     * @return Returns true if there was a collision between the player and the character
     */
    public boolean checkForCollisionWithCharacter(Character character){
        return this.player.getxPos() < character.getxPos() + character.getSizeX()       &&
                character.getxPos() < this.player.getxPos() + this.player.getSizeX()    &&
                this.player.getyPos() < character.getyPos() + character.getSizeY()      &&
                character.getyPos() < this.player.getyPos() + this.player.getSizeY();
    }

    /**
     * Checks for a collision between the player and an item placed somewhere in the world
     * @param item The item that might have collided with the player
     * @return Returns true if there was a collision between the player and the item
     */
    public boolean checkForCollisionWithItem(Item item){
        return this.player.getxPos() < item.getxPos() + item.getSizeX()       &&
                item.getxPos() < this.player.getxPos() + this.player.getSizeX()    &&
                this.player.getyPos() < item.getyPos() + item.getSizeY()      &&
                item.getyPos() < this.player.getyPos() + this.player.getSizeY();
    }

    /**
     * Handles the process of picking up an item by the player
     * @param item The item that is picked up by the player
     */
    public void pickUpItem(Item item){
        this.player.addItemToInventory(item);
        this.removeItem(item);
        item.setOutInTheWorld(false);
    }

    private int xPos;   //position of active sector of the world that will be shown on screen
    private int yPos;
    private Player player;
    /*
        contains all items of the world that are not stored in the player's inventory or owned by a character
        items can be collected and used by the player, like keys etc.
     */
    private ArrayList<Item> itemList;

    /*
        contains all objects of the world, like trees, houses, fences etc. (=foreground)
        collision detection needed
     */
    private ArrayList<Object> objectList;

    /*
        contains all characters of the world, i.e. all persons not controlled by the human player
        player can talk to and transfer items from/to a character
     */
    private ArrayList<Character> characterList;

    //bufferedImage         //contains background-image, to be implemented later
}