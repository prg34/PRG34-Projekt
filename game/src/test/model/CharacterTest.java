package test.model;

import main.model.Character;
import main.model.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterTest {

    @Test
    public void testGiveItemToPlayer() throws Exception {
        Item ash = new Item("Asche", "Was das wohl mal war?", 15, 15, "finished.png", 250, 100, null, null);
        String sentences = "Hallo!" + "\n" + "Wie geht's?" + "\n" + "Ciao!";
        Character niklas = new Character("Niklas", 15, 15, "finished.png", 250, 100, sentences, ash);

        niklas.receiveItemFromPlayer(ash);
        assertEquals(
                "character should be in possession of the item after it was given to him",
                niklas.isPossessedByCharacter(ash), true);


        niklas.giveItemToPlayer();
        assertEquals(
                "character should be in possession of the item after it was given to him",
                niklas.isPossessedByCharacter(ash), false);
    }

}