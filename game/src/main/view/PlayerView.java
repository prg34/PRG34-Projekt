package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.controller.MainController;
import main.model.Player;

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

    private Player player;
    private MainController mainController;
}
