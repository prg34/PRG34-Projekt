package test.model;

import main.model.*;
import main.model.Character;
import main.model.Object;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * unit tests for the EntityLists methods
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
        assertNotEquals(
                "Checking if we get some valid object from the singleton getInstance()-method",
                EntityLists.getInstance(), null );
    }


    @Test
    public void testAddObject() throws Exception {
        assertEquals(
                "Size should be 0 before adding the first object",
                EntityLists.getInstance().getSizeObjectList(), 0);
        main.model.Object chest = new Object("Tür", 30, 30, "finished.png", 250, 100, null, null);
        EntityLists.getInstance().addObject(chest);
        assertEquals(
                "Size should be 1 now after adding an object",
                EntityLists.getInstance().getSizeObjectList(), 1);
    }

    @Test
    public void testAddCharacter() throws Exception {
        assertEquals(
                "Size should be 0 before adding the first character",
                EntityLists.getInstance().getSizeCharacterList(), 0);
        String sentences = "Hallo!" + "\n" + "Wie geht's?" + "\n" + "Ciao!";
        Character niklas = new Character("Niklas", 15, 15, "finished.png", 250, 100, sentences, null);
        EntityLists.getInstance().addCharacter(niklas);
        assertEquals(
                "Size should be 1 now after adding a character",
                EntityLists.getInstance().getSizeCharacterList(), 1);
    }
}