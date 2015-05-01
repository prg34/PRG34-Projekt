package main.view;

//import main.view.SquareEventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.controller.KeyEventHandler;

public class EntityView extends ImageView{

    public final static Image KNIGHT_IMAGE = new Image(EntityView.class.getResource("/images/knight.png").toString());

    private GameMap gameMap;
    private int xPos, yPos;

    public EntityView(GameMap gameMap, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.gameMap = gameMap;
        setImage(KNIGHT_IMAGE);
        setOnKeyPressed(new KeyEventHandler());
    }

    /**
     * Returns the x position of this SquareView on the GameMap
     *
     * @return
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Set the x position of this SquareView on the GameMap
     *
     * @param xPos
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Returns the y position of this SquareView on the GameMap
     *
     * @return
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Set the y position of this SquareView on the GameMap
     *
     * @param yPos
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
