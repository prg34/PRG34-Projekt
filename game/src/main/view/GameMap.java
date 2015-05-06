package main.view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.controller.MainController;

public class GameMap {

    private final static Image BACKGROUND_IMAGE = new Image(GameMap.class.getResource("/images/background.png").toString());

    private Group mainGroup;
    private Group entityGroup;
    private EntityView entityView;
    private MainController mainController;

    /**
     * Creates a new GameMap
     */
    public GameMap(MainController mainController) {
        this.mainController = mainController;
        initGameMap();
    }

    /**
     * Initializes a new GameMap
     */
    private void initGameMap() {
        entityGroup = new Group();
        mainGroup = new Group();
        entityView = new EntityView(mainController);

        entityView.setTranslateX(130);
        entityView.setTranslateY(130);
        entityGroup.getChildren().add(entityView);
        ImageView backgroundView = new ImageView(BACKGROUND_IMAGE);
        mainGroup.getChildren().add(backgroundView);
        mainGroup.getChildren().add(entityGroup);
    }

    /**
     * Returns the Group this map belongs to.
     *
     * @return Group
     */
    public Group getMainGroup() {
        return mainGroup;
    }
}