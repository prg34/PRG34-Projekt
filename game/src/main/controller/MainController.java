package main.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.model.*;
import main.model.Object;
import main.view.*;

import java.util.ArrayList;

public class MainController extends Application {

    /**
     * Anchor for JavaFx to start the application
     * Initializes a new JavaFx-Scene
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {

        world = new World(0, 0);
        EntityLists.getInstance().setWorld(world);
        player = new Player("Spieler", 250, 250, "player.png", 50, 50);
        EntityLists.getInstance().setPlayer(player);
        someObject = new Object("irgendein Objekt", 100, 100, "object.png", 100, 100, null, null);
        EntityLists.getInstance().addObject(someObject);
        item = new Item("Gabel", "Yup, eine Gabel!", 500, 500, "item.png", 50, 50, null, null);
        EntityLists.getInstance().addItem(item);
        item2 = new Item("Messer", "ein Messer!", 100, 500, "item.png", 50, 50, null, null);
        EntityLists.getInstance().addItem(item2);
        String[] sentences = {"Hallo!", "Wie geht's?", "Ciao!"};
        character = new main.model.Character("Nessi", 500, 100, "character.png", 50, 50, sentences, new ArrayList<Item>());
        EntityLists.getInstance().addCharacter(character);

        playerView = new PlayerView(player);
        playerView.setTranslateX(player.getxPos());
        playerView.setTranslateY(player.getyPos());
        objectView = new ObjectView(someObject);
        objectView.setTranslateX(someObject.getxPos());
        objectView.setTranslateY(someObject.getyPos());
        itemView = new ItemView(item);
        itemView.setTranslateX(item.getxPos());
        itemView.setTranslateY(item.getyPos());
        itemView2 = new ItemView(item2);
        itemView2.setTranslateX(item2.getxPos());
        itemView2.setTranslateY(item2.getyPos());
        characterView = new CharacterView(character);
        characterView.setTranslateX(character.getxPos());
        characterView.setTranslateY(character.getyPos());

        Group entityGroup = new Group();
        entityGroup.getChildren().add(playerView);
        entityGroup.getChildren().add(objectView);
        entityGroup.getChildren().add(itemView);
        entityGroup.getChildren().add(itemView2);
        entityGroup.getChildren().add(characterView);

        Group mainGroup = new Group();
        this.mapView = new MapView();
        mainGroup.getChildren().add(mapView.getBackgroundView());
        mainGroup.getChildren().add(entityGroup);
        Scene scene = new Scene(mainGroup, 704, 704);

        primaryStage.setTitle("Point and Click Adventure");
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

    public class KeyEventHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent ke) {
            final int stepSize = 5;

            if (ke.getCode() == KeyCode.DOWN) {
                player.setyPos(player.getyPos() + stepSize);
                if (world.checkForCollision()){
                    player.setyPos(player.getyPos() - stepSize);
                }
            }
            else if (ke.getCode() == KeyCode.UP) {
                player.setyPos(player.getyPos() - stepSize);
                if (world.checkForCollision()){
                    player.setyPos(player.getyPos() + stepSize);
                }
            }
            else if (ke.getCode() == KeyCode.RIGHT) {
                player.setxPos(player.getxPos() + stepSize);
                if (world.checkForCollision()){
                    player.setxPos(player.getxPos() - stepSize);
                }
            }
            else if (ke.getCode() == KeyCode.LEFT) {
                player.setxPos(player.getxPos() - stepSize);
                if (world.checkForCollision()){
                    player.setxPos(player.getxPos() + stepSize);
                }
            }
            playerView.setTranslateX(player.getxPos());
            playerView.setTranslateY(player.getyPos());
            ke.consume();
        }
    }

    private World world;
    private MapView mapView;
    private Player player;
    private PlayerView playerView;
    private main.model.Object someObject;
    private ObjectView objectView;
    private Item item;
    private ItemView itemView;
    private Item item2;
    private ItemView itemView2;
    private main.model.Character character;
    private CharacterView characterView;
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