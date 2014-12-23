package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * contains and manages all objects in the (game-)world
 */
public class World {
    public World() {
    }

    public void update() {
    }

    public void draw() {
    }

    public void addItem(Item item) {
    }

    public Item removeItem(string itemname) {

        return item;
    }

    public void addObject(Object object) {
    }

    public void addCharacter(Character character) {
    }

    private int xPos;
    private int yPos;
    //bufferedImage array
    private Player player;
    private ArrayList<Item> itemList;
    private ArrayList<Object> objectList;
    private ArrayList<Character> characterList;
}
