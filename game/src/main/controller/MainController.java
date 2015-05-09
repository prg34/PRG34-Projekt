package main.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.model.Player;
import main.model.World;
import main.model.Object;
import main.view.MapView;
import main.view.ObjectView;
import main.view.PlayerView;

public class MainController extends Application {

    /**
     * Anchor for JavaFx to start the application
     * Initializes a new JavaFx-Scene
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {

        this.world = new World(0, 0);
        this.player = new Player("Spieler", 150, 150, "knight.png", 32, 32);
        world.addPlayer(player);
        someObject = new Object("irgendein Objekt", 50, 50, "object.png", 100, 100, null, null);
        world.addObject(someObject);

        this.playerView = new PlayerView(player);
        playerView.setTranslateX(player.getxPos());
        playerView.setTranslateY(player.getyPos());
        this.objectView = new ObjectView(someObject);
        objectView.setTranslateX(someObject.getxPos());
        objectView.setTranslateY(someObject.getyPos());

        Group entityGroup = new Group();
        entityGroup.getChildren().add(playerView);
        entityGroup.getChildren().add(objectView);

        Group mainGroup = new Group();
        this.mapView = new MapView();
        mainGroup.getChildren().add(mapView.getBackgroundView());
        mainGroup.getChildren().add(entityGroup);
        Scene scene = new Scene(mainGroup, 352, 352);

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

            if (ke.getCode() == KeyCode.DOWN) {
                player.setyPos(player.getyPos() + 2);
                if (world.checkForCollision()){
                    player.setyPos(player.getyPos() - 2);
                }
            }
            else if (ke.getCode() == KeyCode.UP) {
                player.setyPos(player.getyPos() - 2);
                if (world.checkForCollision()){
                    player.setyPos(player.getyPos() + 2);
                }
            }
            else if (ke.getCode() == KeyCode.RIGHT) {
                player.setxPos(player.getxPos() + 2);
                if (world.checkForCollision()){
                    player.setxPos(player.getxPos() - 2);
                }
            }
            else if (ke.getCode() == KeyCode.LEFT) {
                player.setxPos(player.getxPos() - 2);
                if (world.checkForCollision()){
                    player.setxPos(player.getxPos() + 2);
                }
            }
            playerView.setTranslateX(player.getxPos());
            playerView.setTranslateY(player.getyPos());
            ke.consume();
        }
    }

    private Player player;
    private World world;
    private MapView mapView;
    private PlayerView playerView;
    private Object someObject;
    private ObjectView objectView;
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