package main.view;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.Object;

public class ObjectView extends ImageView{

    public ObjectView(Object object) {
            this.object = object;
            String path = "/images/" + object.getImageFilename();
            final Image OBJECT_IMAGE = new Image(PlayerView.class.getResource(path).toString());
            setImage(OBJECT_IMAGE);
        }

    private Object object;

}