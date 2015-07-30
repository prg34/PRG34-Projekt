package test.model;

import main.model.Item;
import main.model.Object;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * unit tests for the object methods
 */
public class ObjectTest {

    @Test
    public void testUseItemToOpen() throws Exception {
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", 15, 15, "finished.png", 250, 100, null, null);
        Item key = new Item("Schlüssel", "Ein Schlüssel um etwas zu öffnen", 20, 20, "finished.png", 250, 100, null, null);
        Object chest = new Object("Tür", 30, 30, "finished.png", 250, 100, key, ring);

        assertEquals(
                "After using the key with the chest, the content of the chest (the ring) is returned",
                chest.useItemToOpen(key), ring );
    }
}