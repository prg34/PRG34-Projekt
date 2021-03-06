package main.model;

import javax.persistence.*;

/**
 * the characters in the world the player is able to interact with
 */

@Entity
public class Character extends GameEntity {

    public Character(String name, int xPos, int yPos, String imageFilename, int sizeX, int sizeY, String sentences, Item item) {
        super(name, xPos, yPos, sizeX, sizeY, imageFilename);
        this.sentences = sentences;
        this.item = item;
    }

    //JPA asks for a no-arg constructor
    public Character() {
        super();
        this.sentences = null;
        this.item = null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Delivers the answer of the character when the player talks to him
     * @return The answer of the character to be shown on screen
     */
    public String getSentences() {
        return sentences;
    }

    /**
     * Handles transfer of item from player to this character
     * @param item The item that is transferred from player to this character
     */
    public void receiveItemFromPlayer(Item item){
        if (item != null) {
            this.item = item;
            item.setIsInInventory(false);
        }
    }

    /**
     * Handles transfer of item from character to player
     * @return The item that is transferred so player can add it to his inventory
     */
    public Item giveItemToPlayer(){
        Item itemTemp = this.item;
        itemTemp.setIsInInventory(true);
        item = null;
        return itemTemp;
    }

    /**
     * Checks if item is in possession character
     * @param item The item to be checked
     * @return If item is in possession of character then return = true, else return = false
     */
    public boolean isPossessedByCharacter(Item item){
        return this.item == item;
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

    public void setSentences(String sentences) {
        this.sentences = sentences;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * contains the text the character is able to say
     */
    @Column
    private String sentences;

    /**
     * the item the character possesses and gives to the player when talked to
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    Item item;
}
