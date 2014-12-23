package de.fherfurt.prg34;

/**
 * the Character controlled by the human player
 */
public class Player {
    public Player(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        xSpeed = 0;
        ySpeed = 0;
        width = 20;
        height = 20;
    }

    public void draw() {
    }

    public void update() {
    }

    public void takeItem(Item item) {
        this.inventory.addItem(item);
    }

    public void giveItemTo(Item item, Character character) {
        //...
        this.inventory.removeItem(item);
    }

    /* still to be implemented:
    talkTo(Character character)
    open(Object object)
    useItem(item)
	useItemWith(item1, item2)
	useItemWith(item1, object)
    lookAt(item / object)
    */

    private String name;
    private int xPos;
    private int yPos;
    private double xSpeed;
    private double ySpeed;
    private int width;
    private int height;
    private Inventory inventory;
    //bufferedImage     //to be implemented later
}
