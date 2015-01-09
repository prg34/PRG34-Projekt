package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testAddItem() throws Exception {
        Player player = new Player("Spieler", 0, 0);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", null, null, 15, 15, false);
        Item plate = new Item("Teller", "Ein gefüllter Teller.", null, null, 15, 15, false);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", plate, ring, 10, 10, false);

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
}