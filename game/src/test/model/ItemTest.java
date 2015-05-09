package test.model;

import main.model.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testUseWithItem() throws Exception {
        Item ash = new Item("Asche", "Was das wohl mal war?", 15, 15, "finished.png", 250, 100, null, null);
        Item log = new Item("Holzscheit", "Ein stück leicht entzündbares, trockenes Holz.", 15, 15, "finished.png", 250, 100, null, ash);
        Item match = new Item("Streichholz", "Ein perfektes Streichholz.", 15, 15, "finished.png", 250, 100, log, ash);

        assertEquals(
                "After using the match on the log, the item ash is returned",
                match.useWithItem(log), ash);
    }
}
