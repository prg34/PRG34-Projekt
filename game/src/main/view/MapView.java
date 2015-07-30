package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * view of the world map
 */
public class MapView {

    private final static Image backgroundImage = new Image(MapView.class.getResource("/background.png").toString());

    public MapView() {
    }

    public ImageView getBackgroundView()
    {
        return new ImageView(backgroundImage);
    }
}