package test.model;

import main.model.*;
import main.model.Character;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * unit tests for the player methods
 */
public class PlayerTest {

    @Test
    public void testAddItem() throws Exception {
        Player player = new Player("Spieler", 0, 0, "knight.png", 32, 32);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", 15, 15, "key.png", 250, 100, null, null);
        Item plate = new Item("Teller", "Ein gefüllter Teller.", 15, 15, "key.png", 250, 100, null, null);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", 15, 15, "key.png", 250, 100, plate, ring);

        //spoon is used with plate in the proper order, the resulting ring is stored in the player's inventory
        player.addItemToInventory(spoon.useWithItem(plate));
        assertEquals(
                "After using the spoon with the plate, the ring should be added to the inventory, so size will be 1",
                player.getInventorySize(), 1);
    }

    @Test
    public void testGiveItemToCharacter() throws Exception {
        Player player = new Player("Spieler", 0, 0, "knight.png", 32, 32);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", 15, 15, "key.png", 250, 100, null, null);

        String sentences = "Hallo!" + "\n" + "Wie geht's?" + "\n" + "Ciao!";
        Character monster = new Character("Nessi", 20, 20, "character.png", 250, 100, sentences, ring);


        player.addItemToInventory(ring);
        assertEquals(
                "after adding item to inventory, size of inventory should be 1",
                player.getInventorySize(), 1);
        assertEquals(
                "after adding item to inventory, item should be part of list now",
                player.isInInventory(ring), true);


        player.giveItemToCharacter(ring, monster);
        assertEquals(
                "after giving item to character, it is no longer in the player's inventory",
                player.isInInventory(ring), false);
        assertEquals(
                "after giving item to character, monster should now possess the item",
                monster.isPossessedByCharacter(ring), true);
    }

    @Test
    public void testRemoveItem() throws Exception {
        Player player = new Player("Spieler", 0, 0, "player.png", 32, 32);
        EntityLists.getInstance().setPlayer(player);
        Item ash = new Item("Asche", "Was das wohl mal war?", 15, 15, "key.png", 250, 100, null, null);
        EntityLists.getInstance().getPlayer().addItem(ash);
        EntityLists.getInstance().getPlayer().removeItem(ash);

        assertEquals(
                "After removeItem(ash) the item should be no longer in the inventory",
                EntityLists.getInstance().getPlayer().isInInventory(ash), false);

    }

}