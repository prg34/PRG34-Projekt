package main.model;

import javax.persistence.*;

/**
 * Base class for all Entities in the game (items, characters and objects)
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class GameEntity {
    public GameEntity(String name, int xPos, int yPos, int sizeX, int sizeY, String imageFilename)
    {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.imageFilename = imageFilename;
    }

    public GameEntity()
    {
        this.name = "";
        this.xPos = 0;
        this.yPos = 0;
        this.sizeX = 0;
        this.sizeY = 0;
        this.imageFilename = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName(){
        return name;
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

    public String getImageFilename(){
        return imageFilename;
    }

    /**
     * getter and setter for JPA-access
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    @Column
    protected final String name;
    @Column
    protected int xPos;           //position of the character in the world, marks upper left corner
    @Column
    protected int yPos;
    @Column
    protected final int sizeX;
    @Column
    protected final int sizeY;
    @Column
    protected String imageFilename;
}
