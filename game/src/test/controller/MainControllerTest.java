package test.controller;

import main.controller.MainController;
import main.model.*;
import main.model.Character;
import main.model.Object;
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
                "with the given coordinates and sizes, there should be a collission between the player and the entity (item in this case)",
                mainController.checkForCollision(), true);
    }

    @Test
    public void testCheckForCollisionWithObject() throws Exception {
        Player player = new Player("Spieler", 10, 10, "knight.png", 32, 32);
        Object chest = new Object("Tür", 15, 15, "finished.png", 250, 100, null, null);
        MainController mainController = new MainController();

        EntityLists.getInstance().setPlayer(player);

        assertEquals(
                "with the given coordinates and sizes, there should be a collission between the player and the object",
                mainController.checkForCollisionWithObject(chest), true);
    }

    @Test
    public void testCheckForCollisionWithCharacter() throws Exception {
        Player player = new Player("Spieler", 10, 10, "knight.png", 32, 32);
        String sentences = "Hallo!" + "\n" + "Wie geht's?" + "\n" + "Ciao!";
        main.model.Character niklas = new Character("Niklas", 15, 15, "finished.png", 250, 100, sentences, null);
        MainController mainController = new MainController();

        EntityLists.getInstance().setPlayer(player);

        assertEquals(
                "with the given coordinates and sizes, there should be a collission between the player and the character",
                mainController.checkForCollisionWithCharacter(niklas), true);
    }

    @Test
    public void testCheckForCollisionWithItem() throws Exception {
        Player player = new Player("Spieler", 10, 10, "knight.png", 32, 32);
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", 15, 15, "finished.png", 250, 100, null, null);
        MainController mainController = new MainController();

        EntityLists.getInstance().setPlayer(player);

        assertEquals(
                "with the given coordinates and sizes, there should be a collission between the player and the item",
                mainController.checkForCollisionWithItem(item), true);
    }

    @Test
    public void testPickUpItem() throws Exception {
        MainController mainController = new MainController();
        Item item = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", 15, 15, "finished.png", 250, 100, null, null);
        EntityLists.getInstance().addItem(item);
        assertEquals(
                "Item should be placed in the world",
                EntityLists.getInstance().getSizeItemList(), 2);
        assertEquals(
                "Item is not in inventory yet",
                item.isInInventory(), false);
        mainController.pickUpItem(item);
        assertEquals(
                "Item was removed from the world and added to the inventory of the player",
                EntityLists.getInstance().getSizeItemList(), 1);
        assertEquals(
                "Item should be in inventory now",
                item.isInInventory(), true);
    }
}