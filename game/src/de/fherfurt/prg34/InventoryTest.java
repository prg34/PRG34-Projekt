package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void testAddItem() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15);
        inventar.addItem(ash);

        assertEquals(
                "After addItem(), the item should be in the inventory",
                inventar.isInInventory(ash), true);
    }

    @Test
    public void testRemoveItem() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15);
        inventar.addItem(ash);
        inventar.removeItem(ash);

        assertEquals(
                "After removeItem(ash) the item should be no longer in the inventory",
                inventar.isInInventory(ash), false);

    }

    //identical to first unit test above
    /*
    @Test
    public void testIsInInventory() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15, false);
        inventar.addItem(ash);

        assertEquals(
                "After the method isInInventory, its shown weather ash is in the inventory or not",
                inventar.isInInventory(ash), true);
    }
    */
}