package main.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * contains and manages all items collected by the player
 */
@Entity
public class Inventory {
    public Inventory() {
        this.itemList = new ArrayList<Item>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Adds an item to the inventory of the player, e.g. after the player picked up an item or received one from a character
     * @param item Item to be added to the inventory
     */
    public void addItem(Item item) {
        if ((item != null) && (!this.isInInventory(item)))
            itemList.add(item);
    }

    /**
     * Removes the item from the inventory of the player, e.g. after the player used an item or gave it to a character
     * @param item Item to be removed from inventory
     */
    public void removeItem(Item item) {
        itemList.remove(item);
    }

    /**
     * Returns the size of the inventory, only necessary for unit tests so far
     * @return Size of inventory
     */
    public int getInventorySize(){
        return itemList.size();
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

    @OneToMany
    private List<Item> itemList;   //to collect all items of the inventory
}
