package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * main class to create all objects initially and run the game;
 * to be implemented later, so far only for test purposes
 */
public class Game {
    public static void main(String[] args) {

        Player player = new Player("Spieler", 0, 0);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", "Teller", "Nahrungsaufnahme", 10, 10);
        Object tree = new Object("Baum", 10, 10);
        String[] saetze = new String[10];
        saetze[0] = "Hallo!";
        saetze[1] = "Ciao!";
        Character monster = new Character("Nessi", 20, 20, saetze, new ArrayList<Item>());
        World world = new World(0, 0);
        world.addPlayer(player);
        world.addItem(spoon);
        world.addObject(tree);
        world.addCharacter(monster);

        world.removeItem(spoon);
    }
}
