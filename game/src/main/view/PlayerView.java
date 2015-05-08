package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerView extends ImageView{

    public final static Image KNIGHT_IMAGE = new Image(PlayerView.class.getResource("/images/knight.png").toString());

    public PlayerView() {
        setImage(KNIGHT_IMAGE);
    }
}
