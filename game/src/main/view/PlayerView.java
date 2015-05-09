package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.Player;

public class PlayerView extends ImageView{

    public PlayerView(Player player) {
        this.player = player;
        String path = "/images/" + player.getImageFilename();
        final Image KNIGHT_IMAGE = new Image(PlayerView.class.getResource(path).toString());
        setImage(KNIGHT_IMAGE);
    }

    private Player player;
}
