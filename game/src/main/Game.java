package main;

import main.model.Item;
import main.model.Object;
import main.model.Player;
import main.model.World;

import java.util.ArrayList;

import main.view.GameMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * main class to create all objects initially and run the game;
 * to be implemented later, so far only for test purposes
 */
/*
public class Game {
    public static void main(String[] args) {

        //just playing around a little with the objects, to show how they can be used later in the actual game

        Player player = new Player("Spieler", 0, 0);
        Item ring = new Item("Kristallring", "Ein funkelnder Kristallring.", null, null, 15, 15);
        Item plate = new Item("Teller", "Ein gefüllter Teller.", null, null, 15, 15);
        Item spoon = new Item("Löffel", "Ein ganz normaler Suppenlöffel.", plate, ring, 10, 10);
        Item key = new Item("Schlüssel", "Ein Schlüssel um etwas zu öffnen", null, null, 20, 20);
        Object tree = new Object("Baum", 10, 10, null, null);
        Object door = new Object("Tür", 30, 30, key, null);

        //create string array for character
        String[] sentences = {"Hallo!", "Wie geht's?", "Ciao!"};
        main.model.Character monster = new main.model.Character("Nessi", 20, 20, sentences, new ArrayList<Item>());
        
        //place all objects in the world
        World world = new World(0, 0);
        world.addPlayer(player);
        world.addItem(spoon);
        world.addItem(plate);
        world.addItem(key);
        world.addObject(tree);
        world.addObject(door);
        world.addCharacter(monster);

        //spoon is used with plate, the resulting ring is stored in the player's inventory
        player.addItemToInventory(spoon.useWithItem(plate));
        //the other way round, nothing should happen
        player.addItemToInventory(plate.useWithItem(spoon));

        world.removeItem(spoon);
    }
}
*/

public class Game extends Application {

    /**
     * Initializes a new JavaFx-Scene with a game map
     *
     * @return Scene
     */
    public Scene initGameScene(){
        GameMap gameMap = new GameMap();
        Scene scene = new Scene(gameMap.getMainGroup(), 352, 352);
        return scene;
    }

    /**
     * Anchor for JavaFx to start the application
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Point and Click Adventure");
        primaryStage.setScene(initGameScene());
        primaryStage.show();
    }

    /**
     * Usually ignored, only used if JavaFx can not not be started with start(Stage)
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
