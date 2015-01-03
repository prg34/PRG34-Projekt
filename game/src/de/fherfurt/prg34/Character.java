package de.fherfurt.prg34;

import com.sun.deploy.ui.ImageLoader;
import javafx.scene.layout.Background;
import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Character {


    private String name;
    private int xPos;
    private int yPos;
    private int sizeX;
    private int sizeY;
    private String[] sentences = new String[10];
    private Item [] itemCollection = new Item[10];
    private BufferedImage picture;
    private BufferedImage[] character = new BufferedImage[10];

    public Character(String name, int xPos, int yPos, String[] sentences, Item[] itemCollection) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeX = 50;
        this.sizeY = 20;
        this.sentences = sentences;
        this.itemCollection = itemCollection;

        try
        {
            character[0] = ImageIO.read(getClass().getClassLoader().getResource("Bild.png")); // move player picture
            character[1] = ImageIO.read(getClass().getClassLoader().getResource("Bild.png")); // move player picture


        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void draw(java.awt.Graphics G)
    {
        G.drawImage(picture, (int) xPos, (int) yPos, null);
    }

    public void update()
    {
        int Time= 20;
        int Counter = 0;

        if (Counter >= Time)
        {
            Counter = 0;
        }
        if (Counter >= 0)
        {
            picture = character[0];
            Counter++;
        }
        if(Counter == 10)
        {
            picture = character[1];
            Counter ++;
        }

        else
        {
            Counter++;
        }



    }


    public void speak(String sentence)
    {
        System.out.println(sentence);
    }


}
