package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.controller.MainController;
import main.model.Player;

/**
 * view of the player
 */
public class PlayerView extends ImageView{

    public PlayerView(Player player, MainController mainController) {
        this.player = player;
        this.mainController = mainController;
        String path = "/" + player.getImageFilename();
        try {
            final Image playerImage = new Image(PlayerView.class.getResource(path).toString());
            setImage(playerImage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * reference to the corresponding data object
     */
    private Player player;

    /**
     * reference to the controller
     */
    private MainController mainController;
}
