package main.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * collects all entities in the game (items, objects, characters) and the player object
 * realized as a singleton to get easy access to it
 */
@Entity
public class EntityLists {

    private static EntityLists instance;

    // made the constructor "protected", cause JPA asked for it (despite the fact it's a singleton)
    protected EntityLists()
    {
        this.player = null;
        this.itemList = new ArrayList<Item>();
        this.objectList = new ArrayList<Object>();
        this.characterList = new ArrayList<Character>();
    }

    public static EntityLists getInstance () {
        if (EntityLists.instance == null) {
            EntityLists.instance = new EntityLists();
        }
        return EntityLists.instance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Sets the player reference to the actual player object
     * @param player The actual player that is used in this game
     */
    public void setPlayer(Player player){
        if (player != null)
            this.player = player;
    }

    /**
     * Adds an item to the world, used for initial creation of the world
     * @param item The Item that is to be added to the world
     */
    public void addItem(Item item) {
        if ((item != null) && (!this.itemList.contains(item))) {
            this.itemList.add(item);
            item.setIsInInventory(false);
        }
    }

    /**
     * Removes an item from the world, e.g. after the item was picked up by the player and added to his inventory
     * @param item The item to be removed from the world
     */
    public void removeItem(Item item) {
        if ((item != null) && (this.itemList.contains(item))) {
            this.itemList.remove(item);
        }
    }

    /**
     * Adds an object to the world, used for initial creation of the world
     * @param object The object that is to be added to the world
     */
    public void addObject(Object object) {
        if ((object != null) && (!this.objectList.contains(object)))
            this.objectList.add(object);
    }

    /**
     * Adds a character to the world, used for initial creation of the world
     * @param character The character that is to be added to the world
     */
    public void addCharacter(Character character) {
        if ((character != null) && (!this.characterList.contains(character)))
            this.characterList.add(character);
    }

    /**
     * Returns the size of the item list, only necessary for unit tests so far
     * @return Size of itemList
     */
    public int getSizeItemList(){
        return itemList.size();
    }

    public Player getPlayer()
    {
        return player;
    }

    public List<Item> getItemList()
    {
        return itemList;
    }

    public List<Object> getObjectList()
    {
        return objectList;
    }

    public List<Character> getCharacterList()
    {
        return characterList;
    }

    public void setItemList(List<Item> itemList)
    {
        this.itemList = itemList;
    }

    public void setObjectList(List<Object> objectList)
    {
        this.objectList = objectList;
    }

    public void setCharacterList(List<Character> characterList)
    {
        this.characterList = characterList;
    }

    /**
     * getter and setter for JPA-access
     */
    public static void setInstance(EntityLists instance) {
        EntityLists.instance = instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    private Player player;

    /*
        contains all items of the world that are not stored in the player's inventory or owned by a character
        items can be collected and used by the player, like keys etc.
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Item> itemList;

    /*
        contains all objects of the world, like trees, houses, fences etc. (=foreground)
        collision detection needed
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Object> objectList;

    /*
        contains all characters of the world, i.e. all persons not controlled by the human player
        player can talk to and transfer items from/to a character
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Character> characterList;
}
