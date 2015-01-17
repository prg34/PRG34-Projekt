package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectTest {

    @Test
    public void testUseItemToOpen() throws Exception {
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", null, null, 15, 15, false);
        Item key = new Item("Schlüssel", "Ein Schlüssel um etwas zu öffnen", null, null, 20, 20, false);
        Object chest = new Object("Tür", 30, 30, key, ring);

        assertEquals(
                "After using the key with the chest, the content of the chest (the ring) is returned",
                chest.useItemToOpen(key), ring );
    }
}