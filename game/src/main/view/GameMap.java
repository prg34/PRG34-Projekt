package main.view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameMap {

    private final static Image BACKGROUND_IMAGE = new Image(GameMap.class.getResource("/images/background.png").toString());

    private Group mainGroup;
    private Group entityGroup;
    private EntityView entityView;

    /**
     * Creates a new GameMap
     */
    public GameMap() {
        initGameMap();
    }

    /**
     * Initializes a new GameMap
     */
    private void initGameMap() {
        entityGroup = new Group();
        //mainGroup = new Group();
        entityView = new EntityView(this, 5, 5);

        entityView.setTranslateX(130);
        entityView.setTranslateY(130);
        entityGroup.getChildren().add(entityView);
        ImageView backgroundView = new ImageView(BACKGROUND_IMAGE);
        mainGroup = new Group(backgroundView, entityGroup);
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
