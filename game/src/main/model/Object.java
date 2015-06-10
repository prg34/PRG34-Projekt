package main.model;

import javax.persistence.*;

/**
 * The objects contained in the world (like trees, fences, doors, houses etc.)
 * with certain objects the user is able to interact (like open a door)
 */
@Entity
public class Object extends GameEntity {
    public Object(String name, int xPos, int yPos, String imageFilename, int sizeX, int sizeY, Item openedWithItem, Item content) {
        super(name, xPos, yPos, sizeX, sizeY, imageFilename);
        this.opened = false;
        this.openedWithItem = openedWithItem;
        this.content = content;
    }

    public Object() {
        super();
        this.opened = false;
        this.openedWithItem = null;
        this.content = null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Used if player opens an object, e.g. a door or a chest
     * changes state of the object
     */
    public void open() {
        this.opened = true;
    }

    /**
     * Used if player closes an object, e.g. a door or a chest
     * changes state of the object
     */
    public void close() {
        this.opened = false;
    }

    /**
     * Uses an item with an object to try to open it, if they match the object opens (door, chest),
     * and gives back its contents (if object is a chest)
     * @param item The item that is used to try to open the object
     * @return The item that is given back if object is a chest
     */
    public Item useItemToOpen(Item item){
        Item result = null;
        if (item == this.openedWithItem){
            open();
            result = this.content;
        }
        return result;
    }

    private boolean opened;      // shows if the object ist opened or closed, like chests or doors, default value closed
    @OneToOne
    private Item openedWithItem;    //proper item, like a key, to open a door or a chest
    @OneToOne
    private Item content;          //if chest was opened, content of it is returned
}