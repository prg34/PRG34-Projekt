package test.model;

import main.model.Character;
import main.model.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CharacterTest {

    @Test
    public void testGiveItemToPlayer() throws Exception {
        Item ash = new Item("Asche", "Was das wohl mal war?", null, null, 15, 15);
        String[] sentences = {"Hallo!", "Wie geht's?", "Ciao!"};
        Character niklas = new Character("Niklas", 15, 15, sentences, new ArrayList<Item>());

        niklas.receiveItemFromPlayer(ash);
        assertEquals(
                "character should be in possession of the item after it was given to him",
                niklas.isPossessedByCharacter(ash), true);


        niklas.giveItemToPlayer(ash);
        assertEquals(
                "character should be in possession of the item after it was given to him",
                niklas.isPossessedByCharacter(ash), false);
    }

}