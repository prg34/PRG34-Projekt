package main.view;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.controller.MainController;
import main.model.*;

/**
 * view of an item
 */
public class ItemView extends ImageView {

        public ItemView(Item item, MainController mainController) {
            this.item = item;
            this.mainController = mainController;
            String path = "/" + item.getImageFilename();
            try {
                final Image itemImage = new Image(ItemView.class.getResource(path).toString());
                setImage(itemImage);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            setOnMousePressed(new MouseEventHandler());
        }

        public Item getItem()
        {return item;}

    /**
     * Handles mouse clicks on an item
     */
        public class MouseEventHandler implements EventHandler<MouseEvent> {
            @Override
            public void handle(MouseEvent me) {
                mainController.processMouseEvent(item);
            }
        }

        private Item item;
        private MainController mainController;
    }
