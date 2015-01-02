package de.fherfurt.prg34;

/**
 * main class to create all objects initially and run the game;
 * to be implemented later
 */
public class Game {
    public static void main(String[] args) {

        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", "Teller", "Nahrungsaufnahme", 10, 10);
        World world = new World(0, 0);
        world.addItem(spoon);
        world.removeItem(spoon);
    }
}
