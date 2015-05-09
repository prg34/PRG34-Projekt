package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.Player;

public class PlayerView extends ImageView{

    public final static Image KNIGHT_IMAGE = new Image(PlayerView.class.getResource("/images/knight.png").toString());

    public PlayerView(Player player) {
        this.player = player;
        setImage(KNIGHT_IMAGE);
    }

    private Player player;
}
