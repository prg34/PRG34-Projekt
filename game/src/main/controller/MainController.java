package main.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.view.GameMap;

public class MainController extends Application {

    /**
     * Anchor for JavaFx to start the application
     * Initializes a new JavaFx-Scene with a game map
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Point and Click Adventure");
        GameMap gameMap = new GameMap(this);
        Scene scene = new Scene(gameMap.getMainGroup(), 352, 352);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new KeyEventHandler());
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


/*
public class Game {
    public static void main(String[] args) {

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