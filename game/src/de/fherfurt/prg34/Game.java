package de.fherfurt.prg34;

/**
 * main class to create all objects initially and run the game;
 * to be implemented later
 */
public class Game {
    public static void main(String[] args) {

        Item item = new Item();
        World world = new World();
        world.addItem(item);
        world.removeItem(item);
    }
}
