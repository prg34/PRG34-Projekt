package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * contains and manages all items collected by the player
 */
public class Inventory {
    public Inventory() {
        this.itemList = new ArrayList<Item>();
    }

    /**
     * Adds an item to the inventory of the player, e.g. after the player picked up an item or received one from a character
     * @param item Item to be added to the inventory
     */
    public void addItem(Item item) {
        itemList.add(item);
    }

    /**
     * Removes the item from the inventory of the player, e.g. after the player used an item or gave it to a character
     * @param item Item to be removed from inventory
     */
    public void removeItem(Item item) {
        itemList.remove(item);
    }

    /**
     * used to draw the inventory and its contents on the screen, called by class Frame
     * to be implemented later
     */
    public void draw() {

    }

    private ArrayList<Item> itemList;   //to collect all items of the inventory
}
