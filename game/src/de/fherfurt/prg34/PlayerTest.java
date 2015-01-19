package de.fherfurt.prg34;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testAddItem() throws Exception {
        Player player = new Player("Spieler", 0, 0);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", null, null, 15, 15);
        Item plate = new Item("Teller", "Ein gefüllter Teller.", null, null, 15, 15);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", plate, ring, 10, 10);

        //spoon is used with plate, the resulting ring is stored in the player's inventory
        player.addItemToInventory(spoon.useWithItem(plate));
        assertEquals(
                "After using the spoon with the plate, the ring should be added to the inventory, so size will be 1",
                player.getInventorySize(), 1);

        //the other way round, nothing should happen
        player.addItemToInventory(plate.useWithItem(spoon));
        assertEquals(
                "using the plate on the spoon has no effect, i.e. nothing new is added to the inventory, so size is still 1",
                player.getInventorySize(), 1);
    }

    @Test
    public void testGiveItemToCharacter() throws Exception {
        Player player = new Player("Spieler", 0, 0);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", null, null, 15, 15);

        //create string array for character
        String[] sentences = {"Hallo!", "Wie geht's?", "Ciao!"};
        Character monster = new Character("Nessi", 20, 20, sentences, new ArrayList<Item>());


        player.addItemToInventory(ring);
        assertEquals(
                "after adding item to inventory, size of inventory should be 1",
                player.getInventorySize(), 1);
        assertEquals(
                "after adding item to inventory, item should be part of list now",
                player.isInInventory(ring), true);
        assertEquals(
                "monster does not own the item yet",
                monster.isPossessedByCharacter(ring), false);


        player.giveItemToCharacter(ring, monster);
        assertEquals(
                "after giving item to character, it is no longer in the player's inventory",
                player.isInInventory(ring), false);
        assertEquals(
                "after giving item to character, monster should now possess the item",
                monster.isPossessedByCharacter(ring), true);


        player.takeItemFromCharacter(ring, monster);
        assertEquals(
                "after taking item from character, it should be part of the inventory list again",
                player.isInInventory(ring), true);
        assertEquals(
                "after giving back the item to the player, character does not own the item anymore",
                monster.isPossessedByCharacter(ring), false);
    }

}