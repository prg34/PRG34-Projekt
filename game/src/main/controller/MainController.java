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
import javafx.scene.text.*;
import main.model.*;
import main.model.Character;
import main.model.Object;
import main.view.*;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * main controller class, takes care of the initialization of the game, collision detection and keyboard handling
 */
public class MainController extends Application {

    /**
     * initializes all entities in the game
     */
    private void initGame()
    {
        Player player = new Player("Spieler", 250, 450, "player.png", 73, 72);
        EntityLists.getInstance().setPlayer(player);
        PlayerView playerView = new PlayerView(player, this);
        playerView.setTranslateX(player.getxPos());
        playerView.setTranslateY(player.getyPos());
        addView(playerView);
        this.playerView = playerView;

        Object someObject = new Object("Ein ganz nettes Haus", 1, 1, "house.png", 295, 300, null, null);
        EntityLists.getInstance().addObject(someObject);
        ObjectView objectView = new ObjectView(someObject, this);
        objectView.setTranslateX(someObject.getxPos());
        objectView.setTranslateY(someObject.getyPos());
        addView(objectView);
        modelToView.put(someObject, objectView);

        Item key = new Item("Schlüssel", "Yup, ein Schlüssel!", 500, 500, "key.png", 50, 50, null, null);
        EntityLists.getInstance().addItem(key);
        ItemView itemView = new ItemView(key, this);
        itemView.setTranslateX(key.getxPos());
        itemView.setTranslateY(key.getyPos());
        addView(itemView);
        modelToView.put(key, itemView);

        Item umbrella = new Item("Regenschirm", "Ein Regenschirm, nützlich wenn es regnet!", 100, 500, "umbrella.png", 50, 50, null, null);
        ItemView itemView2 = new ItemView(umbrella, this);
        itemView2.setVisible(false);
        addView(itemView2);
        modelToView.put(umbrella, itemView2);

        String sentences = "Hallo!" + "\n" + "Wie geht's?";
        Character character = new Character("Fred", 500, 100, "character.png", 73, 72, sentences, umbrella);
        EntityLists.getInstance().addCharacter(character);
        CharacterView characterView = new CharacterView(character, this);
        characterView.setTranslateX(character.getxPos());
        characterView.setTranslateY(character.getyPos());
        addView(characterView);
        modelToView.put(character, characterView);
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
        modelToView = new Hashtable<GameEntity, ImageView>();
        outputText = new Text();
        jpaController = new JPAController();

        initGame();

        /**
         * creates all buttons of the GUI and adds them to the mainGroup / Scene
         */
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

        Button SaveButton = new Button("Speichern");
        SaveButton.setTranslateX(320);
        SaveButton.setTranslateY(704);
        SaveButton.setOnMousePressed(new MouseEventHandlerSaveButton());
        SaveButton.setFocusTraversable(false);

        Button LoadButton = new Button("Laden");
        LoadButton.setTranslateX(390);
        LoadButton.setTranslateY(704);
        LoadButton.setOnMousePressed(new MouseEventHandlerLoadButton());
        LoadButton.setFocusTraversable(false);

        outputText.setTranslateY(754);

        Group entityGroup = new Group();

        for (ImageView view : viewList)
        {
            entityGroup.getChildren().add(view);
        }

        /**
         * adds all views to the scene
         */
        this.mainGroup = new Group();
        MapView mapView = new MapView();
        mainGroup.getChildren().add(mapView.getBackgroundView());
        mainGroup.getChildren().add(entityGroup);
        mainGroup.getChildren().add(useButton);
        mainGroup.getChildren().add(giveButton);
        mainGroup.getChildren().add(infoButton);
        mainGroup.getChildren().add(talkButton);
        mainGroup.getChildren().add(pickUpButton);
        mainGroup.getChildren().add(SaveButton);
        mainGroup.getChildren().add(LoadButton);
        mainGroup.getChildren().add(outputText);
        Scene scene = new Scene(mainGroup, 754, 794);

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

    /**
     * defines the different mouse event handlers for the various buttons
     */
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

    public class MouseEventHandlerSaveButton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            jpaController.save();
            outputText.setText("Spielstand gespeichert");
        }
    }

    public class MouseEventHandlerLoadButton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            if (jpaController.load()) outputText.setText("Spielstand geladen");
            drawInventory();
        }
    }

    /**
     * the key event handler for controlling the player, so far only up, down, left and right are available
     */
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

    /**
     * adds a view to the viewList, so that the views can be added to the scene later
     */
    public void addView(ImageView view) {
        if ((view != null) && (!this.viewList.contains(view))) {
            this.viewList.add(view);
        }
    }

    /**
     * Checks for a collision between the player and all items, objects and characters in the game
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
     * must be public, or otherwise unit test cannot access it (same for following methods)
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

    /**
     * the actual game logic, is called (by the views) every time the user clicks on an entity on the UI
     * clickedButton contains the button that was clicked before
     * @param clickedObject the entity on the UI that was clicked last
     */
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
                        item.setIsInInventory(true);
                        player.removeItemFromInventory((Item) firstClickedObject);
                        ((Item) firstClickedObject).setIsInInventory(false);
                        player.removeItemFromInventory((Item) clickedObject);
                        ((Item) clickedObject).setIsInInventory(false);
                        modelToView.get(firstClickedObject).setVisible(false);
                        modelToView.get(clickedObject).setVisible(false);
                    }
                    clickedButton = ClickedButton.NONE;
                }
                else if (firstClickedObject instanceof Item && clickedObject instanceof Object)
                {
                    item = ((Object) clickedObject).useItemToOpen((Item)firstClickedObject);
                    if (item != null) {
                        player.addItemToInventory(item);
                        item.setIsInInventory(true);
                        player.removeItemFromInventory((Item) firstClickedObject);
                        modelToView.get(firstClickedObject).setVisible(false);
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
                    ((Item) firstClickedObject).setIsInInventory(false);
                    outputText.setText(((Item) firstClickedObject).getName() + " an " + ((Character) clickedObject).getName() + " übergeben");
                    clickedButton = ClickedButton.NONE;
                    modelToView.get(firstClickedObject).setVisible(false);
                    drawInventory();
                }
                break;

            case INFO:
                if (clickedObject instanceof Item)
                {
                    outputText.setText(((Item) clickedObject).lookAt());
                }
                else if (clickedObject instanceof Object)
                {
                    outputText.setText(((Object) clickedObject).getName());
                }
                clickedButton = ClickedButton.NONE;
                break;

            case TALK:
                if (clickedObject instanceof Character)
                {
                    outputText.setText(((Character) clickedObject).getSentences());
                    Item itemReceived = ((Character) clickedObject).giveItemToPlayer();
                    if (itemReceived != null) {
                        EntityLists.getInstance().getPlayer().addItemToInventory(itemReceived);
                        itemReceived.setIsInInventory(true);
                        modelToView.get(itemReceived).setVisible(true);
                    }
                }
                clickedButton = ClickedButton.NONE;
                drawInventory();
                break;

            case PICKUP:
                if (clickedObject instanceof Item)
                {
                    pickUpItem((Item) clickedObject);
                    ((Item) clickedObject).setIsInInventory(true);
                    outputText.setText("Item " + ((Item) clickedObject).getName() + " aufgelesen");
                    drawInventory();
                }
                break;
        }
    }

    /**
     * calls the view of every item stored in the inventory, aligns them vertically on the right side of the GUI
     */
    public void drawInventory()
    {
        int counter = 0;
        for (Item item : EntityLists.getInstance().getPlayer().getInventory())
        {
            ImageView imageView = modelToView.get(item);
            if (imageView != null) {
                imageView.setTranslateX(704);
                imageView.setTranslateY(counter * 50);
            }
            ++counter;
        }
    }

    /**
     * main group for creating the scene
     */
    private Group mainGroup;

    /**
     * collects all views from the game initialization, so they can be added to the scene then
     */
    private ArrayList<ImageView> viewList;

    /**
     * reference to the view of the player, need access to it to change x- and y- coordinates
     */
    private PlayerView playerView;

    public enum ClickedButton {NONE, USE, GIVE, INFO, TALK, PICKUP}
    /**
     * marks which button was clicked last
     */
    private ClickedButton clickedButton;

    /**
     * marks which entity was clicked first, for actions involving 2 entities
     */
    private java.lang.Object firstClickedObject;

    /**
     * to store which view belongs to which model-object, needed for drawInventory()
     */
    private Hashtable<GameEntity, ImageView> modelToView;

    /**
     * to draw text on the UI
     */
    Text outputText;

    /**
     * reference to the JPA controller to store the objects in a database
     */
    JPAController jpaController;
}