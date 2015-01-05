package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * contains and manages all objects in the game-world
 */
public class World {
    public World(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
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
     * used to draw the world on the screen, called by class Frame
     * calls draw methods of all items, objects and characters it manages
     * to be implemented later
     */
    public void draw() {
    }

    /**
     * Adds an item to the world, used for initial creation of the world
     * @param item The Item that is to be added to the world
     */
    public void addItem(Item item) {
        this.itemList.add(item);
    }

    /**
     * Removes an item from the world, e.g. after the item was picked up by the player and added to his inventory
     * @param item The item to be removed from the world
     */
    public void removeItem(Item item) {
        this.itemList.remove(item);
    }

    /**
     * Adds an object to the world, used for initial creation of the world
     * @param object The object that is to be added to the world
     */
    public void addObject(Object object) {
        this.objectList.add(object);
    }

    /**
     * Adds a character to the world, used for initial creation of the world
     * @param character The character that is to be added to the world
     */
    public void addCharacter(Character character) {
        this.characterList.add(character);
    }

    /**
     * Returns the size of the item list, only necessary for unit tests so far
     * @return Size of itemList
     */
    public int getSizeItemList(){
        return itemList.size();
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