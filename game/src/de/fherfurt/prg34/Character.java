package de.fherfurt.prg34;

/*
import com.sun.deploy.ui.ImageLoader;
import javafx.scene.layout.Background;
import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
*/
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Character {

    public Character(String name, int xPos, int yPos, String[] sentences, ArrayList<Item> itemList) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeX = 50;
        this.sizeY = 20;
        this.animationCounter = 0;
        this.sentences = sentences;
        this.itemList = new ArrayList<Item>(itemList);
        /*
        try
        {
            character[0] = ImageIO.read(getClass().getClassLoader().getResource("Bild.png")); // move player picture
            character[1] = ImageIO.read(getClass().getClassLoader().getResource("Bild.png")); // move player picture
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        */
    }

    public void draw(java.awt.Graphics G) {
        G.drawImage(picture, xPos, yPos, null);
    }

    public void update() {
        animationCounter++;

        if (animationCounter > animationTime) {
            animationCounter = 0;
        }
        if (animationCounter == 0) {
            picture = character[0];
        }
        if(animationCounter == 10) {
            picture = character[1];
        }
    }

    /**
     * Delivers the answer of the character when the player talks to him
     * @param num Tells which of the characters possible answers is used here
     * @return The answer of the character to be shown on screen
     */
    public String getSentence(int num) {
        return sentences[num];
    }

    /**
     * Handles transfer of item from player to this character
     * @param item The item that is transferred from player to this character
     */
    public void receiveItemFromPlayer(Item item){
        if ((item != null) && (!this.itemList.contains(item)))
            this.itemList.add(item);
    }

    /**
     * Handles transfer of item from character to player
     * @param item The item that is transferred from character to player
     * @return The item that is transferred so player can add it to his inventory
     */
    public Item giveItemToPlayer(Item item){
        this.itemList.remove(item);
        return item;
    }

    /**
     * Checks if item is in possession character
     * @param item The item to be checked
     * @return If item is in possession of character then return = true, else return = false
     */
    public boolean isPossessedByCharacter(Item item){
        return this.itemList.contains(item);
    }

    public void draw(){

    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    private final String name;
    private int xPos;           //position of the character in the world, marks upper left corner
    private int yPos;
    private final int sizeX;
    private final int sizeY;
    private final int animationTime = 20;
    private int animationCounter;
    private String[] sentences = new String[10];
    private ArrayList<Item> itemList;               //contains all items the character holds
    private BufferedImage picture;
    private BufferedImage[] character = new BufferedImage[10];
}
