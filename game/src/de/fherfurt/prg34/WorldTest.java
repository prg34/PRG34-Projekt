package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void testAddItem() throws Exception {
        World world = new World(0, 0);
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", null, null, 10, 10, false);
        Item item2 = new Item("Löffel2", "Ein ganz normaler Suppenlöffel.", item, item, 10, 10, false);
        world.addItem(item);
        world.addItem(item2);
        assertEquals(
                "After adding 2 items to a new itemList, its size should be 2",
                world.getSizeItemList(), 2);
        world.removeItem(item);
        world.removeItem(item);
        assertEquals(
                "After removing 'item', its size should be 1 now",
                world.getSizeItemList(), 1 );
    }

    @Test
    public void testCheckForCollision() throws Exception {
        World world = new World(0, 0);
        Player player = new Player("Spieler", 10, 10);
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", null, null, 20, 25, false);

        world.addPlayer(player);
        world.addItem(item);

        assertEquals(
                "After adding 2 items to a new itemList, its size should be 2",
                world.checkForCollision(), true);

    }
}