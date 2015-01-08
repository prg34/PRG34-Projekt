package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testAddItem() throws Exception {
        Player player = new Player("Spieler", 0, 0);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", null, null, 15, 15);
        Item plate = new Item("Teller", "Ein gefüllter Teller.", null, null, 15, 15);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", plate, ring, 10, 10);

        //spoon is used with plate, the resulting ring is stored in the player's inventory
        player.addItem(spoon.useItemWith(plate));
        assertEquals(
                "After using the spoon with the plate, the ring should be added to the inventory, so size will be 1",
                player.getInventorySize(), 1);

        //the other way round, nothing should happen
        player.addItem(plate.useItemWith(spoon));
        assertEquals(
                "using the plate on the spoon has no effect, i.e. nothing new is added to the inventory, so size is still 1",
                player.getInventorySize(), 1);
    }
}