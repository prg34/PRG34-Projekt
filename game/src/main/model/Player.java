package main.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the main character controlled by the human player
 */
@Entity
public class Player {
    public Player(String name, int xPos, int yPos, String imageFilename, int sizeX, int sizeY) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.imageFilename = imageFilename;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.itemList = new ArrayList<Item>();
    }

    //JPA asks for a no-arg constructor
    protected Player() {
        this.name = "";
        this.xPos = 0;
        this.yPos = 0;
        this.imageFilename = "";
        this.sizeX = 0;
        this.sizeY = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Adds an item to the inventory the player just picked up or got form somewhere else
     * @param item The item the player just picked up
     */
    public void takeItem(Item item) {
        this.addItemToInventory(item);
        item.setIsInInventory(true);
    }

    /**
     * Handles the transfer of an item from player to a character
     * @param item The item the player gives to the character
     * @param character The character the player gives the item to
     */
    public void giveItemToCharacter(Item item, Character character) {
        character.receiveItemFromPlayer(item);
        removeItem(item);
        item.setIsInInventory(false);
    }

    /**
     * Delivers the answer of the character the player talks to
     * @param character The character the player talks to
     * @return The answer of the character to be shown on screen
     */
    String talkTo(Character character){
        return character.getSentences();
    }

    /**
     * Adds an item to the inventory of the player, e.g. after the player picked up an item or received one from a character
     * @param item Item to be added to the inventory
     */
    public void addItemToInventory(Item item) {
        addItem(item);
        item.setIsInInventory(true);
    }

    /**
     * Removes the item from the inventory of the player, e.g. after the player used an item or gave it to a character
     * @param item Item to be removed from inventory
     */
    public void removeItemFromInventory(Item item) {
        removeItem(item);
        item.setIsInInventory(false);
    }

    public int getyPos() {
        return yPos;
    }

    /**
     * tries to set the player to the new position, makes sure the player is not outside of the game world
     * @param yPos the new y-coordinate of the player
     */
    public void setyPos(int yPos)
    {
        this.yPos = yPos;
        if (this.yPos > sizeWorldY - sizeY) this.yPos = sizeWorldY - sizeY;
        if (this.yPos < 0) this.yPos = 0;
    }

    public int getxPos() {
        return xPos;
    }

    /**
     * tries to set the player to the new position, makes sure the player is not outside of the game world
     * @param xPos the new x-coordinate of the player
     */
    public void setxPos(int xPos)
    {
        this.xPos = xPos;
        if (this.xPos > sizeWorldX - sizeX) this.xPos = sizeWorldX - sizeX;
        if (this.xPos < 0) this.xPos = 0;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public List<Item> getInventory()
    {
        return itemList;
    }

    public String getImageFilename(){
        return this.imageFilename;
    }

    /**
     * Adds item to inventory
     * @param item The item to be added to the inventory
     */
    public void addItem(Item item) {
        if ((item != null) && (!this.isInInventory(item))) {
            itemList.add(item);
            item.setIsInInventory(true);
        }
    }

    /**
     * Removes the item from the inventory of the player, e.g. after the player used an item or gave it to a character
     * @param item Item to be removed from inventory
     */
    public void removeItem(Item item) {
        itemList.remove(item);
        item.setIsInInventory(false);
    }

    /**
     * Returns the size of the inventory, only necessary for unit tests so far
     * @return Size of inventory
     */
    public int getInventorySize(){
        return itemList.size();
    }

    public void setInventory(List<Item> inventoryList)
    {
        this.itemList = inventoryList;
    }

    public List<Item> getItemList()
    {
        return itemList;
    }

    /**
     * Checks if item is already in inventory
     * @param item The item to be checked
     * @return If item is in inventory then return = true, else return = false
     */
    public boolean isInInventory(Item item){
        return this.itemList.contains(item);
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

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    final int sizeWorldX = 704;                 //size of the world to check if player reached the right or lower border
    final int sizeWorldY = 704;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Item> itemList;                //to collect all items of the inventory
    @Column
    private String name;                        //name of the player
    @Column
    private int xPos;                           //position of the player in the world, marks upper left corner
    @Column
    private int yPos;
    @Column
    private String imageFilename;
    @Column
    private final int sizeX;                    //size of the player in pixels for collision detection
    @Column
    private final int sizeY;
}
