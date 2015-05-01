package main.view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameMap {

    private final static Image BACKGROUND_IMAGE = new Image(GameMap.class.getResource("/images/background.png").toString());

    private Group mainGroup;
    private Group entityGroup;
    //private SquareView activeSquare;
    //private SquareView[][] squareViews;
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
        //squareViews = new SquareView[SQUARE_XY_COUNT][SQUARE_XY_COUNT];
        entityView = new EntityView(this, 5, 5);

		/* Initialize all fields with knights and empty images */
        /*
        for (int x = 0; x < SQUARE_XY_COUNT; x++) {
            for (int y = 0; y < SQUARE_XY_COUNT; y++) {
                if ((x > 3 && x < 7 && y > 0 && y < 10 && y != 5)
                        || (y > 3 && y < 7 && x > 0 && x < 10 && x != 5))
                    squareViews[x][y] = new SquareView(this, x, y, SquareView.OCCUPIED);
                else if (y == 5 && x == 5)
                    squareViews[x][y] = new SquareView(this, x, y, SquareView.EMPTY);
                else
                    squareViews[x][y] = new SquareView(this, x, y, SquareView.INACCESSIBLE);
            }
        }
        */

		/* Set the position of all the layers and add all the squares to a group */
        /*
        for (int x = 0; x < SQUARE_XY_COUNT; x++) {
            for (int y = 0; y < SQUARE_XY_COUNT; y++) {
                if (squareViews[x][y] != null) {
                    squareViews[x][y].setTranslateX(x * SQUARE_PX_WIDTH);
                    squareViews[x][y].setTranslateY(y * SQUARE_PX_HEIGHT);
                    knightGroup.getChildren().add(squareViews[x][y]);
                }
            }
        }
        */
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
