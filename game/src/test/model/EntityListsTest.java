package test.model;

import main.model.EntityLists;
import main.model.Item;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class EntityListsTest {

    @Test
    public void testAddItem() throws Exception {
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

    @Test
    public void testGetInstance() throws Exception {

    }

    @Test
    public void testSetPlayer() throws Exception {

    }

    @Test
    public void testRemoveItem() throws Exception {

    }

    @Test
    public void testAddObject() throws Exception {

    }

    @Test
    public void testAddCharacter() throws Exception {

    }

    @Test
    public void testGetSizeItemList() throws Exception {

    }

    @Test
    public void testGetPlayer() throws Exception {

    }

    @Test
    public void testGetItemList() throws Exception {

    }

    @Test
    public void testGetObjectList() throws Exception {

    }

    @Test
    public void testGetCharacterList() throws Exception {

    }

    @Test
    public void testSetItemList() throws Exception {

    }

    @Test
    public void testSetObjectList() throws Exception {

    }

    @Test
    public void testSetCharacterList() throws Exception {

    }
}