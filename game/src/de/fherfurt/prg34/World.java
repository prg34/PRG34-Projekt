package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * contains and manages all objects in the (game-)world
 */
public class World {
    public World() {
        xPos = 0;
        yPos = 0;
        this.itemList = new ArrayList<Item>();
        this.objectList = new ArrayList<Object>();
        this.characterList = new ArrayList<Character>();
    }

    public void update() {
    }

    public void draw() {
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }

    public void addObject(Object object) {
        this.objectList.add(object);
    }

    public void addCharacter(Character character) {
        this.characterList.add(character);
    }

    private int xPos;
    private int yPos;
    //bufferedImage   //to be implemented later
    private Player player;
    private ArrayList<Item> itemList;
    private ArrayList<Object> objectList;
    private ArrayList<Character> characterList;
}