package main.view;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.model.Object;

public class ObjectView extends ImageView{

    public ObjectView(Object object) {
            this.object = object;
            String path = "/images/" + object.getImageFilename();
            final Image OBJECT_IMAGE = new Image(PlayerView.class.getResource(path).toString());
            setImage(OBJECT_IMAGE);
        setOnMousePressed(new MouseEventHandler());
        }

    public class MouseEventHandler implements EventHandler<MouseEvent> {
        /**
         * Handles mouse clicks on an object
         *
         * @param mouseEvent
         */
        @Override
        public void handle(MouseEvent me) {

		    /* Get the current clicked object */
            java.lang.Object object = me.getSource();
            if (object instanceof ObjectView) {
                System.out.println("Objekt geklickt");
            }
        }
    }

    private Object object;

}