package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * contains and manages all items collected by the player
 */
public class Inventory {
    public Inventory() {
        size = 10;
        itemList = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public void draw() {

    }

    private int size;
    private ArrayList<Item> itemList;
}
