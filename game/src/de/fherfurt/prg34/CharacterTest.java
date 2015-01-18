package de.fherfurt.prg34;

import org.junit.Before;
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
        Character Niklas = new Character("Niklas", 15, 15, "Ich habe Asche für dich", ash);                                 /*wegen string []*/

        assertEquals(
                "After the method giveItemToPlayer, the Item is given.",
                Niklas.giveItemToPlayer(ash));
    }

}