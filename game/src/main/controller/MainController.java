package main.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.model.*;
import main.model.Character;
import main.model.Object;
import main.view.*;

import java.util.ArrayList;

public class MainController extends Application {

    private void initGame()
    {
        Player player = new Player("Spieler", 250, 250, "player.png", 50, 50);
        EntityLists.getInstance().setPlayer(player);
        PlayerView playerView = new PlayerView(player, this);
        playerView.setTranslateX(player.getxPos());
        playerView.setTranslateY(player.getyPos());
        addView(playerView);
        this.playerView = playerView;

        Object someObject = new Object("irgendein Objekt", 100, 100, "object.png", 100, 100, null, null);
        EntityLists.getInstance().addObject(someObject);
        ObjectView objectView = new ObjectView(someObject, this);
        objectView.setTranslateX(someObject.getxPos());
        objectView.setTranslateY(someObject.getyPos());
        addView(objectView);

        Item item = new Item("Gabel", "Yup, eine Gabel!", 500, 500, "item.png", 50, 50, null, null);
        EntityLists.getInstance().addItem(item);
        ItemView itemView = new ItemView(item, this);
        itemView.setTranslateX(item.getxPos());
        itemView.setTranslateY(item.getyPos());
        addView(itemView);

        Item item2 = new Item("Messer", "ein Messer!", 100, 500, "item.png", 50, 50, null, null);
        EntityLists.getInstance().addItem(item2);
        ItemView itemView2 = new ItemView(item2, this);
        itemView2.setTranslateX(item2.getxPos());
        itemView2.setTranslateY(item2.getyPos());
        addView(itemView2);

        ArrayList<String> sentences = new ArrayList<>();
        sentences.add("Hallo!");
        sentences.add("Wie geht's?");
        sentences.add("Ciao!");
        Character character = new Character("Nessi", 500, 100, "character.png", 50, 50, sentences, item2);
        EntityLists.getInstance().addCharacter(character);
        CharacterView characterView = new CharacterView(character, this);
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

        mainGroup = null;
        viewList = new ArrayList<ImageView>();
        playerView = null;
        clickedButton = ClickedButton.NONE;
        firstClickedObject = null;

        initGame();

        Button useButton = new Button("Benutze");
        useButton.setTranslateX(0);
        useButton.setTranslateY(704);
        useButton.setOnMousePressed(new MouseEventHandlerUseButton());
        useButton.setFocusTraversable(false);

        Button giveButton = new Button("Gib");
        giveButton.setTranslateX(70);
        giveButton.setTranslateY(704);
        giveButton.setOnMousePressed(new MouseEventHandlerGiveButton());
        giveButton.setFocusTraversable(false);

        Button infoButton = new Button("Info");
        infoButton.setTranslateX(120);
        infoButton.setTranslateY(704);
        infoButton.setOnMousePressed(new MouseEventHandlerInfoButton());
        infoButton.setFocusTraversable(false);

        Button talkButton = new Button("Rede mit");
        talkButton.setTranslateX(170);
        talkButton.setTranslateY(704);
        talkButton.setOnMousePressed(new MouseEventHandlerTalkButton());
        talkButton.setFocusTraversable(false);

        Button pickUpButton = new Button("Nimm");
        pickUpButton.setTranslateX(250);
        pickUpButton.setTranslateY(704);
        pickUpButton.setOnMousePressed(new MouseEventHandlerPickUpButton());
        pickUpButton.setFocusTraversable(false);

        Group entityGroup = new Group();

        for (ImageView view : viewList)
        {
            entityGroup.getChildren().add(view);
        }

        this.mainGroup = new Group();
        MapView mapView = new MapView();
        mainGroup.getChildren().add(mapView.getBackgroundView());
        mainGroup.getChildren().add(entityGroup);
        mainGroup.getChildren().add(useButton);
        mainGroup.getChildren().add(giveButton);
        mainGroup.getChildren().add(infoButton);
        mainGroup.getChildren().add(talkButton);
        mainGroup.getChildren().add(pickUpButton);
        Scene scene = new Scene(mainGroup, 704, 754);

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

    public class MouseEventHandlerUseButton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            firstClickedObject = null;
            clickedButton = ClickedButton.USE;
        }
    }

    public class MouseEventHandlerGiveButton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            firstClickedObject = null;
            clickedButton = ClickedButton.GIVE;
        }
    }

    public class MouseEventHandlerInfoButton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            firstClickedObject = null;
            clickedButton = ClickedButton.INFO;
        }
    }

    public class MouseEventHandlerTalkButton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            firstClickedObject = null;
            clickedButton = ClickedButton.TALK;
        }
    }

    public class MouseEventHandlerPickUpButton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            firstClickedObject = null;
            clickedButton = ClickedButton.PICKUP;
        }
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

    public void processMouseEvent(java.lang.Object clickedObject)
    {
        switch(clickedButton)
        {
            case NONE:
                break;

            case USE:
                Player player = EntityLists.getInstance().getPlayer();
                Item item;
                if (firstClickedObject == null && clickedObject instanceof Item)
                {
                    firstClickedObject = clickedObject;
                }
                else if (firstClickedObject instanceof Item && clickedObject instanceof Item)
                {
                    item = ((Item) firstClickedObject).useWithItem((Item) clickedObject);
                    if (item != null) {
                        player.addItemToInventory(item);
                        player.removeItemFromInventory((Item) firstClickedObject);
                        player.removeItemFromInventory((Item) clickedObject);
                    }
                    clickedButton = ClickedButton.NONE;
                }
                else if (firstClickedObject instanceof Item && clickedObject instanceof Object)
                {
                    item = ((Object) clickedObject).useItemToOpen((Item)firstClickedObject);
                    if (item != null) {
                        player.addItemToInventory(item);
                        player.removeItemFromInventory((Item) firstClickedObject);
                    }
                    clickedButton = ClickedButton.NONE;
                }
                break;

            case GIVE:
                if (firstClickedObject == null && clickedObject instanceof Item)
                {
                    firstClickedObject = clickedObject;
                }
                else if (firstClickedObject instanceof Item && clickedObject instanceof Character)
                {
                    EntityLists.getInstance().getPlayer().giveItemToCharacter((Item)firstClickedObject, (Character)clickedObject);
                    clickedButton = ClickedButton.NONE;
                }
                break;

            case INFO:
                if (clickedObject instanceof Item)
                {
                    System.out.println(((Item) clickedObject).lookAt());
                }
                else if (clickedObject instanceof Object)
                {
                    System.out.println(((Object) clickedObject).getName());
                }
                clickedButton = ClickedButton.NONE;
                break;

            case TALK:
                if (clickedObject instanceof Character)
                {
                    for (String sentence : ((Character) clickedObject).getSentences())
                        System.out.println(sentence);
                    Item itemReceived = ((Character) clickedObject).giveItemToPlayer();
                    EntityLists.getInstance().getPlayer().addItemToInventory(itemReceived);
                }
                clickedButton = ClickedButton.NONE;
                break;

            case PICKUP:
                if (clickedObject instanceof Item)
                {
                    pickUpItem((Item)clickedObject);
                    System.out.println("Item " + ((Item) clickedObject).getName() + " aufgelesen");
                    for (ImageView imageView: viewList) {
                        if (imageView instanceof ItemView)
                        {
                            if (((ItemView) imageView).getItem() == clickedObject)
                            {
                                imageView.setVisible(false);
                                //mainGroup.getChildren().remove(imageView);
                            }
                        }
                    }
                }
                break;
        }
    }

    private Group mainGroup;
    private ArrayList<ImageView> viewList;
    private PlayerView playerView;
    public enum ClickedButton {NONE, USE, GIVE, INFO, TALK, PICKUP}
    private ClickedButton clickedButton;
    private java.lang.Object firstClickedObject;
}


// our old main method
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