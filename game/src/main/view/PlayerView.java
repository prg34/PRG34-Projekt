package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.controller.MainController;
import main.model.Player;

public class PlayerView extends ImageView{

    public PlayerView(Player player, MainController mainController) {
        this.player = player;
        this.mainController = mainController;
        String path = "/images/" + player.getImageFilename();
        final Image KNIGHT_IMAGE = new Image(PlayerView.class.getResource(path).toString());
        setImage(KNIGHT_IMAGE);
    }

    private Player player;
    private MainController mainController;
}
