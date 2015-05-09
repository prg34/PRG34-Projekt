package main.view;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.model.*;

public class ItemView extends ImageView {

        public ItemView(Item item) {
            this.item = item;
            String path = "/images/" + item.getImageFilename();
            final Image ITEM_IMAGE = new Image(PlayerView.class.getResource(path).toString());
            setImage(ITEM_IMAGE);
            setOnMousePressed(new MouseEventHandler());
        }

        public class MouseEventHandler implements EventHandler<MouseEvent> {
            /**
             * Handles mouse clicks on an object
             *
             */
            @Override
            public void handle(MouseEvent me) {
                System.out.println("Item \"" + item.getName() + "\" geklickt");
            }
        }

        private Item item;

    }
