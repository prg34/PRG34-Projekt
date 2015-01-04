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
        animationTime = 20;
        animationCounter = 0;
        this.sentences = sentences;
        this.itemList = new ArrayList<Item>(itemList);

        try
        {
            character[0] = ImageIO.read(getClass().getClassLoader().getResource("Bild.png")); // move player picture
            character[1] = ImageIO.read(getClass().getClassLoader().getResource("Bild.png")); // move player picture


        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void draw(java.awt.Graphics G) {
        G.drawImage(picture, xPos, yPos, null);
    }

    public void update() {

        if (animationCounter >= animationTime) {
            animationCounter = 0;
        }
        if (animationCounter == 0) {
            picture = character[0];
            animationCounter++;
        }
        if(animationCounter == 10) {
            picture = character[1];
            animationCounter++;
        }
        else {
            animationCounter++;
        }

    }

    /*
    output will be handled by draw()-method
    getSentence()-method provides proper answer as string to draw()-method for output
    */
    /*
    public void speak(String sentence) {
        System.out.println(sentence);
    }
    */

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

    private String name;
    private int xPos;
    private int yPos;
    private int sizeX;
    private int sizeY;
    private int animationTime;
    private int animationCounter;
    private String[] sentences = new String[10];
    private ArrayList<Item> itemList;               //contains all items the character holds
    private BufferedImage picture;
    private BufferedImage[] character = new BufferedImage[10];
}
