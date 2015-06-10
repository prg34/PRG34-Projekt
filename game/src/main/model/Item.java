package main.model;

import javax.persistence.*;

/**
 * The items contained in the world, the player is allowed to take them and/or use them.
 */
@Entity
public class Item extends GameEntity {
    public Item(String name, String description, int xPos, int yPos, String imageFilename, int sizeX, int sizeY, Item correctlyUsedWithItem, Item correctUseResult) {
        super(name, xPos, yPos, sizeX, sizeY, imageFilename);
        this.description = description;
        this.correctlyUsedWithItem = correctlyUsedWithItem;
        this.correctUseResult = correctUseResult;
    }

    public Item() {
        super();
        this.description = "";
        this.correctlyUsedWithItem = null;
        this.correctUseResult = null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Returns the description of the item to be shown on the screen when player looks at that item
     * @return The description of the item
     */
    public String lookAt(){
        return this.description;
    }

    /**
     * Checks if 2 items match when used with each other and returns a resulting item in that case
     * @param item The item this.item is used with
     * @return The item that is returned if one used 2 matching items in the proper order
     */
	public Item useWithItem(Item item){
        Item result = null;
        if (item == this.correctlyUsedWithItem){
            result = this.correctUseResult;
        }
        return result;
    }

    private final String description;         //is used by Player.lookAt(item)
    @OneToOne
    private final Item correctlyUsedWithItem;
    @OneToOne
    private final Item correctUseResult;
}
