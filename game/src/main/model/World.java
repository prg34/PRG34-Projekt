package main.model;

/**
 * contains and manages all objects in the game-world
 */
public class World {
    public World() {
    }


    /**
     * Handles the process of picking up an item by the player
     * @param item The item that is picked up by the player
     */
    public void pickUpItem(Item item){
        EntityLists.getInstance().getPlayer().addItemToInventory(item);
        EntityLists.getInstance().removeItem(item);
    }

}