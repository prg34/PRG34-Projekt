package main.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.controller.MainController;

public class EntityView extends ImageView{

    public final static Image KNIGHT_IMAGE = new Image(EntityView.class.getResource("/images/knight.png").toString());
    private MainController mainController;

    public EntityView(MainController mainController) {
        this.mainController = mainController;
        setImage(KNIGHT_IMAGE);
    }
}
