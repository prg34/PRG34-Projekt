package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapView {

    private final static Image BACKGROUND_IMAGE = new Image(MapView.class.getResource("/background.png").toString());


    public MapView() {
    }

    public ImageView getBackgroundView()
    {
        return new ImageView(BACKGROUND_IMAGE);
    }
}