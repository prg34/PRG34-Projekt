package test.controller;

import main.controller.MainController;
import main.model.EntityLists;
import main.model.Item;
import main.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class MainControllerTest {

    @Test
    public void testCheckForCollision() throws Exception {
        Player player = new Player("Spieler", 10, 10, "knight.png", 32, 32);
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", 15, 15, "finished.png", 250, 100, null, null);
        MainController mainController = new MainController();

        EntityLists.getInstance().setPlayer(player);
        EntityLists.getInstance().addItem(item);

        assertEquals(
                "with the given coordinates and sizes, there should be a collission between the 2 objects",
                mainController.checkForCollision(), true);
    }

    @Test
    public void testStart() throws Exception {

    }

    @Test
    public void testMain() throws Exception {

    }

    @Test
    public void testAddView() throws Exception {

    }

    @Test
    public void testCheckForCollisionWithObject() throws Exception {

    }

    @Test
    public void testCheckForCollisionWithCharacter() throws Exception {

    }

    @Test
    public void testCheckForCollisionWithItem() throws Exception {

    }

    @Test
    public void testPickUpItem() throws Exception {

    }

    @Test
    public void testProcessMouseEvent() throws Exception {

    }

    @Test
    public void testDrawInventory() throws Exception {

    }
}