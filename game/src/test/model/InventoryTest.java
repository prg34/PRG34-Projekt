package test.model;

import main.model.Inventory;
import main.model.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void testAddItem() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", 15, 15, "finished.png", 250, 100, null, null);
        inventar.addItem(ash);

        assertEquals(
                "After addItem(), the item should be in the inventory",
                inventar.isInInventory(ash), true);
    }

    @Test
    public void testRemoveItem() throws Exception {
        Inventory inventar = new Inventory();
        Item ash = new Item("Asche", "Was das wohl mal war?", 15, 15, "finished.png", 250, 100, null, null);
        inventar.addItem(ash);
        inventar.removeItem(ash);

        assertEquals(
                "After removeItem(ash) the item should be no longer in the inventory",
                inventar.isInInventory(ash), false);

    }
}