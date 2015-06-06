package main.model;

import java.util.ArrayList;

/**
 *
 */
public class EntityLists {

    private static EntityLists instance;

    private EntityLists()
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

    public ArrayList<Item> getItemList()
    {
        return itemList;
    }

    public ArrayList<Object> getObjectList()
    {
        return objectList;
    }

    public ArrayList<Character> getCharacterList()
    {
        return characterList;
    }

    private Player player;
    /*
        contains all items of the world that are not stored in the player's inventory or owned by a character
        items can be collected and used by the player, like keys etc.
     */
    private ArrayList<Item> itemList;

    /*
        contains all objects of the world, like trees, houses, fences etc. (=foreground)
        collision detection needed
     */
    private ArrayList<Object> objectList;

    /*
        contains all characters of the world, i.e. all persons not controlled by the human player
        player can talk to and transfer items from/to a character
     */
    private ArrayList<Character> characterList;
}