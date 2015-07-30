package main.view;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.controller.MainController;
import main.model.Character;

/**
 * view of a character
 */
public class CharacterView extends ImageView {
    public CharacterView(Character character, MainController mainController) {
        this.character = character;
        this.mainController = mainController;
        String path = "/" + character.getImageFilename();
        try {
            final Image characterImage = new Image(CharacterView.class.getResource(path).toString());
            setImage(characterImage);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        setOnMousePressed(new MouseEventHandler());
    }

    /**
     * handles mouse clicks on a character
     */
    public class MouseEventHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent me) {
            mainController.processMouseEvent(character);
        }
    }

    private main.model.Character character;
    private MainController mainController;
}
