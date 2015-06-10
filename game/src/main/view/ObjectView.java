package main.view;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.controller.MainController;
import main.model.Object;

public class ObjectView extends ImageView{

    public ObjectView(Object object, MainController mainController) {
        this.object = object;
        this.mainController = mainController;
        String path = "/" + object.getImageFilename();
        try {
            final Image objectImage = new Image(ObjectView.class.getResource(path).toString());
            setImage(objectImage);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        setOnMousePressed(new MouseEventHandler());
        }

    public class MouseEventHandler implements EventHandler<MouseEvent> {
        /**
         * Handles mouse clicks on an object
         *
         */
        @Override
        public void handle(MouseEvent me) {
            mainController.processMouseEvent(object);
        }
    }

    private main.model.Object object;
    private MainController mainController;
}