package de.fherfurt.prg34;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CharacterTest {

    @Test
    public void testReceiveItemFromPlayer() throws Exception { /*relevant? 18.01*/

    }

    @Test
    public void testGiveItemToPlayer() throws Exception {
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15, false);
        String[] sentences = {"Hallo!", "Wie geht's?", "Ciao!"};
        Character niklas = new Character("Niklas", 15, 15, sentences, new ArrayList<Item>());
        niklas.giveItemToPlayer(ash);

        assertEquals(
                "character should be in possession of the item after it was given to him",
                niklas.isPossessedByCharacter(ash), true);
    }

}