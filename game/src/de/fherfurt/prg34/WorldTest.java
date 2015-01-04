package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void testAddItem() throws Exception {
        World world = new World(0, 0);
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", "Teller", "Nahrungsaufnahme", 10, 10);
        world.addItem(item);
        assertEquals(
                "After adding an item to a new itemList, its size should be 1",
                world.getSizeItemList(), 1 );
    }
}