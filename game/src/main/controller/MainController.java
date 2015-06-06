package main.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.model.*;
import main.model.Character;
import main.model.Object;
import main.view.*;

import java.util.ArrayList;

public class MainController extends Application {

    private void initGame()
    {
        Player player;
        PlayerView playerView;
        Object someObject;
        ObjectView objectView;
        Item item;
        ItemView itemView;
        Item item2;
        ItemView itemView2;
        Character character;
        CharacterView characterView;

        player = new Player("Spieler", 250, 250, "player.png", 50, 50);
        EntityLists.getInstance().setPlayer(player);
        someObject = new Object("irgendein Objekt", 100, 100, "object.png", 100, 100, null, null);
        EntityLists.getInstance().addObject(someObject);
        item = new Item("Gabel", "Yup, eine Gabel!", 500, 500, "item.png", 50, 50, null, null);
        EntityLists.getInstance().addItem(item);
        item2 = new Item("Messer", "ein Messer!", 100, 500, "item.png", 50, 50, null, null);
        EntityLists.getInstance().addItem(item2);
        String[] sentences = {"Hallo!", "Wie geht's?", "Ciao!"};
        character = new Character("Nessi", 500, 100, "character.png", 50, 50, sentences, new ArrayList<Item>());
        EntityLists.getInstance().addCharacter(character);

        playerView = new PlayerView(player);
        playerView.setTranslateX(player.getxPos());
        playerView.setTranslateY(player.getyPos());
        addView(playerView);
        this.playerView = playerView;
        objectView = new ObjectView(someObject);
        objectView.setTranslateX(someObject.getxPos());
        objectView.setTranslateY(someObject.getyPos());
        addView(objectView);
        itemView = new ItemView(item);
        itemView.setTranslateX(item.getxPos());
        itemView.setTranslateY(item.getyPos());
        addView(itemView);
        itemView2 = new ItemView(item2);
        itemView2.setTranslateX(item2.getxPos());
        itemView2.setTranslateY(item2.getyPos());
        addView(itemView2);
        characterView = new CharacterView(character);
        characterView.setTranslateX(character.getxPos());
        characterView.setTranslateY(character.getyPos());
        addView(characterView);
    }

    /**
     * Anchor for JavaFx to start the application
     * Initializes a new JavaFx-Scene
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {

        viewList = new ArrayList<ImageView>();

        initGame();

        Group entityGroup = new Group();

        for (ImageView view : viewList)
        {
            entityGroup.getChildren().add(view);
        }

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
            Player player = EntityLists.getInstance().getPlayer();

            if (ke.getCode() == KeyCode.DOWN) {
                player.setyPos(player.getyPos() + stepSize);
                if (checkForCollision()){
                    player.setyPos(player.getyPos() - stepSize);
                }
            }
            else if (ke.getCode() == KeyCode.UP) {
                player.setyPos(player.getyPos() - stepSize);
                if (checkForCollision()){
                    player.setyPos(player.getyPos() + stepSize);
                }
            }
            else if (ke.getCode() == KeyCode.RIGHT) {
                player.setxPos(player.getxPos() + stepSize);
                if (checkForCollision()){
                    player.setxPos(player.getxPos() - stepSize);
                }
            }
            else if (ke.getCode() == KeyCode.LEFT) {
                player.setxPos(player.getxPos() - stepSize);
                if (checkForCollision()){
                    player.setxPos(player.getxPos() + stepSize);
                }
            }
            playerView.setTranslateX(player.getxPos());
            playerView.setTranslateY(player.getyPos());
            ke.consume();
        }
    }

    public void addView(ImageView view) {
        if ((view != null) && (!this.viewList.contains(view))) {
            this.viewList.add(view);
        }
    }


    /**
     * Checks for a collision between the player and all items, objects and characters in the world
     * @return Returns true if there was a collision between the player and anything else
     */
    public boolean checkForCollision(){
        for(Object object : EntityLists.getInstance().getObjectList()) {
            if (checkForCollisionWithObject(object)){
                return true;
            }
        }
        for(Character character : EntityLists.getInstance().getCharacterList()) {
            if (checkForCollisionWithCharacter(character)){
                return true;
            }
        }
        for(Item item : EntityLists.getInstance().getItemList()) {
            if (checkForCollisionWithItem(item)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a collision between the player and an object (like a tree or a house)
     * @param object The object that might have collided with the player
     * @return Returns true if there was a collision between the player and the object
     */
    public boolean checkForCollisionWithObject(Object object){
        Player player = EntityLists.getInstance().getPlayer();
        return player.getxPos() < object.getxPos() + object.getSizeX()       &&
                object.getxPos() < player.getxPos() + player.getSizeX() &&
                player.getyPos() < object.getyPos() + object.getSizeY()      &&
                object.getyPos() < player.getyPos() + player.getSizeY();
    }

    /**
     * Checks for a collision between the player and a character
     * @param character The character that might have collided with the player
     * @return Returns true if there was a collision between the player and the character
     */
    public boolean checkForCollisionWithCharacter(Character character){
        Player player = EntityLists.getInstance().getPlayer();
        return player.getxPos() < character.getxPos() + character.getSizeX()       &&
                character.getxPos() < player.getxPos() + player.getSizeX()    &&
                player.getyPos() < character.getyPos() + character.getSizeY()      &&
                character.getyPos() < player.getyPos() + player.getSizeY();
    }

    /**
     * Checks for a collision between the player and an item placed somewhere in the world
     * @param item The item that might have collided with the player
     * @return Returns true if there was a collision between the player and the item
     */
    public boolean checkForCollisionWithItem(Item item){
        Player player = EntityLists.getInstance().getPlayer();
        return player.getxPos() < item.getxPos() + item.getSizeX()       &&
                item.getxPos() < player.getxPos() + player.getSizeX()    &&
                player.getyPos() < item.getyPos() + item.getSizeY()      &&
                item.getyPos() < player.getyPos() + player.getSizeY();
    }

    /**
     * Handles the process of picking up an item by the player
     * @param item The item that is picked up by the player
     */
    public void pickUpItem(Item item){
        EntityLists.getInstance().getPlayer().addItemToInventory(item);
        EntityLists.getInstance().removeItem(item);
    }

    private MapView mapView;
    private ArrayList<ImageView> viewList;
    private PlayerView playerView;
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