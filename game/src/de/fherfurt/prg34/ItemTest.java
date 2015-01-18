package de.fherfurt.prg34;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testUseWithItem() throws Exception {
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15, false);
        Item log = new Item("Holzscheit", "Ein stück leicht entzündbares, trockenes Holz.", null, ash, 15, 15, false);
        Item match = new Item("Streichholz", "Ein perfektes Streichholz.", log, ash, 15, 15, false);

        assertEquals(
                "After using the match on the log, the item ash is returned",
                match.useWithItem(log));
    }
}
