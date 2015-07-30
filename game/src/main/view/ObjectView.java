package main.view;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.controller.MainController;
import main.model.Object;

/**
 * view of a character
 */
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

    /**
     * Handles mouse clicks on an object
     */
    public class MouseEventHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            mainController.processMouseEvent(object);
        }
    }

    /**
     * reference to the corresponding data object
     */
    private main.model.Object object;

    /**
     * reference to the controller
     */
    private MainController mainController;
}