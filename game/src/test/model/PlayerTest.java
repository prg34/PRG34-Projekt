package test.model;

import main.model.Character;
import main.model.Item;
import main.model.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testAddItem() throws Exception {
        Player player = new Player("Spieler", 0, 0, "knight.png", 32, 32);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", 15, 15, "finished.png", 250, 100, null, null);
        Item plate = new Item("Teller", "Ein gefüllter Teller.", 15, 15, "finished.png", 250, 100, null, null);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", 15, 15, "finished.png", 250, 100, plate, ring);

        //the wrong way, nothing should happen -> inventory size still zero
        player.addItemToInventory(plate.useWithItem(spoon));
        assertEquals(
                "using the plate on the spoon has no effect, i.e. nothing new is added to the inventory, so size is still 1",
                player.getInventorySize(), 0);

        //spoon is used with plate in the proper order, the resulting ring is stored in the player's inventory
        player.addItemToInventory(spoon.useWithItem(plate));
        assertEquals(
                "After using the spoon with the plate, the ring should be added to the inventory, so size will be 1",
                player.getInventorySize(), 1);
    }

    @Test
    public void testGiveItemToCharacter() throws Exception {
        Player player = new Player("Spieler", 0, 0, "knight.png", 32, 32);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", 15, 15, "finished.png", 250, 100, null, null);

        //create string array for character
        ArrayList<String> sentences = new ArrayList<>();
        sentences.add("Hallo!");
        sentences.add("Wie geht's?");
        sentences.add("Ciao!");
        Character monster = new Character("Nessi", 20, 20, "finished.png", 250, 100, sentences, ring);


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

        /*
        player.takeItemFromCharacter(ring, monster);
        assertEquals(
                "after taking item from character, it should be part of the inventory list again",
                player.isInInventory(ring), true);
        assertEquals(
                "after giving back the item to the player, character does not own the item anymore",
                monster.isPossessedByCharacter(ring), false);
        */
    }

}