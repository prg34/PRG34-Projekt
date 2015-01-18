package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void testAddItem() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15, false);

        assertEquals(
                "After addItem, the item should be placed in the inventory",
                inventar.addItem(ash));
    }

    @Test
    public void testRemoveItem() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15, false);
        inventar.addItem(ash);

        assertEquals(
                "After the method removeItem, the inventory should be empty",
                inventar.removeItem(ash));

    }

    @Test
    public void testIsInInventory() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15, false);
        inventar.addItem(ash);

        assertEquals(
                "After the method isInInventory, its shown weather ash is in the inventory or not",
                inventar.isInInventory(ash));
    }

}