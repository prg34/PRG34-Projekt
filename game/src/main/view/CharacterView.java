package main.view;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.controller.MainController;
import main.model.Character;

public class CharacterView extends ImageView {
    public CharacterView(Character character, MainController mainController) {
        this.character = character;
        this.mainController = mainController;
        String path = "/images/" + character.getImageFilename();
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
            mainController.processMouseEvent(character);
            //System.out.println("Character \"" + character.getName() + "\" geklickt");
        }
    }

    private main.model.Character character;
    private MainController mainController;
}
