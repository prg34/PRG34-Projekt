package test.model;

import main.model.EntityLists;
import main.model.Item;
import main.model.Player;
import main.model.World;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void testAddItem() throws Exception {
        World world = new World();
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", 15, 15, "finished.png", 250, 100, null, null);
        Item item2 = new Item("Löffel2", "Ein ganz normaler Suppenlöffel.", 15, 15, "finished.png", 250, 100, item, item);
        EntityLists.getInstance().addItem(item);
        EntityLists.getInstance().addItem(item2);
        assertEquals(
                "After adding 2 items to a new itemList, its size should be 2",
                EntityLists.getInstance().getSizeItemList(), 2);
        EntityLists.getInstance().removeItem(item);
        EntityLists.getInstance().removeItem(item);
        assertEquals(
                "After removing 'item', its size should be 1 now",
                EntityLists.getInstance().getSizeItemList(), 1 );
    }

    //to be moved to Controller
    /*
    @Test
    public void testCheckForCollision() throws Exception {
        World world = new World();
        Player player = new Player("Spieler", 10, 10, "knight.png", 32, 32);
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", 15, 15, "finished.png", 250, 100, null, null);

        EntityLists.getInstance().setPlayer(player);
        EntityLists.getInstance().addItem(item);

        assertEquals(
                "with the given coordinates and sizes, there should be a collission between the 2 objects",
                checkForCollision(), true);
    }
    */
}