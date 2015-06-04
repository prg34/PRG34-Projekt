package main.model;

/**
 * contains and manages all objects in the game-world
 */
public class World {
    public World(int xPos, int yPos) {
        //this.xPos = xPos;
        //this.yPos = yPos;
    }

    /**
     * Checks for a collision between the player and all items, objects and characters in the world
     * @return Returns true if there was a collision between the player and anything else
     */
    public boolean checkForCollision(){
        for(Object object : EntityLists.getInstance().getObjectList()) {
            if (checkForCollisionWithObject(object)){
                return true;
            }
        }
        for(Character character : EntityLists.getInstance().getCharacterList()) {
            if (checkForCollisionWithCharacter(character)){
                return true;
            }
        }
        for(Item item : EntityLists.getInstance().getItemList()) {
            if (checkForCollisionWithItem(item)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a collision between the player and an object (like a tree or a house)
     * @param object The object that might have collided with the player
     * @return Returns true if there was a collision between the player and the object
     */
    public boolean checkForCollisionWithObject(Object object){
        Player player = EntityLists.getInstance().getPlayer();
        return player.getxPos() < object.getxPos() + object.getSizeX()       &&
                object.getxPos() < player.getxPos() + player.getSizeX() &&
                player.getyPos() < object.getyPos() + object.getSizeY()      &&
                object.getyPos() < player.getyPos() + player.getSizeY();
        }

    /**
     * Checks for a collision between the player and a character
     * @param character The character that might have collided with the player
     * @return Returns true if there was a collision between the player and the character
     */
    public boolean checkForCollisionWithCharacter(Character character){
        Player player = EntityLists.getInstance().getPlayer();
        return player.getxPos() < character.getxPos() + character.getSizeX()       &&
                character.getxPos() < player.getxPos() + player.getSizeX()    &&
                player.getyPos() < character.getyPos() + character.getSizeY()      &&
                character.getyPos() < player.getyPos() + player.getSizeY();
    }

    /**
     * Checks for a collision between the player and an item placed somewhere in the world
     * @param item The item that might have collided with the player
     * @return Returns true if there was a collision between the player and the item
     */
    public boolean checkForCollisionWithItem(Item item){
        Player player = EntityLists.getInstance().getPlayer();
        return player.getxPos() < item.getxPos() + item.getSizeX()       &&
                item.getxPos() < player.getxPos() + player.getSizeX()    &&
                player.getyPos() < item.getyPos() + item.getSizeY()      &&
                item.getyPos() < player.getyPos() + player.getSizeY();
    }

    /**
     * Handles the process of picking up an item by the player
     * @param item The item that is picked up by the player
     */
    public void pickUpItem(Item item){
        EntityLists.getInstance().getPlayer().addItemToInventory(item);
        EntityLists.getInstance().removeItem(item);
    }

    //private int xPos;   //position of active sector of the world that will be shown on screen
    //private int yPos;

}