package de.fherfurt.prg34;

import java.util.ArrayList;

/**
 * main class to create all objects initially and run the game;
 * to be implemented later, so far only for test purposes
 */
public class Game {
    public static void main(String[] args) {

        Player player = new Player("Spieler", 0, 0);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", null, null, 15, 15);
        Item plate = new Item("Teller", "Ein gefüllter Teller.", null, null, 15, 15);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", plate, ring, 10, 10);
        Object tree = new Object("Baum", 10, 10);

        //create string array for character
        String[] saetze = {"Hallo!", "Wie geht's?", "Ciao!"};
        Character monster = new Character("Nessi", 20, 20, saetze, new ArrayList<Item>());
        
        //place all objects in the world
        World world = new World(0, 0);
        world.addPlayer(player);
        world.addItem(spoon);
        world.addItem(plate);
        world.addObject(tree);
        world.addCharacter(monster);

        //spoon is used with plate, the resulting ring is stored in the player's inventory
        player.addItem(spoon.useItemWith(plate));
        //the other way round, nothing should happen
        player.addItem(plate.useItemWith(spoon));

        world.removeItem(spoon);
    }
}
