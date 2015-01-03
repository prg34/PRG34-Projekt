package de.fherfurt.prg34;

/**
 * the Character controlled by the human player
 */
public class Player {
    public Player(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = 0;
        this.ySpeed = 0;
        this.width = 20;
        this.height = 20;
    }

    public void draw() {
    }

    public void update() {
    }

    public void takeItem(Item item) {
        this.inventory.addItem(item);
    }

    public void giveItemToCharacter(Item item, Character character) {
        character.receiveItemFromPlayer(item);
        this.inventory.removeItem(item);
    }

    public void takeItemFromCharacter(Item item, Character character) {
        this.inventory.addItem(character.giveItemToPlayer(item));
    }

    String talkTo(Character character, int num){
        return character.getSentence(num);
    }

    /**
     * Returns the description of the item to be shown on the screen when player looked at that item
     * @param item The item the player looks at, lookAt(item)
     * @return The description of the item to be shown on Screen
     */
    public String lookAt(Item item){
        return item.getDescription();
    }

    /* still to be implemented:
    useItem(item)
	useItemWith(item1, item2)
	useItemWith(item1, object)
    */

    private String name;
    private int xPos;
    private int yPos;
    private double xSpeed;
    private double ySpeed;
    private int width;
    private int height;
    private Inventory inventory;
    //bufferedImage      //to be implemented later
}
