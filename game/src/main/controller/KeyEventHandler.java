package main.controller;

import main.view.GameMap;
import main.view.EntityView;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;


public class KeyEventHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent ke) {

        System.out.println(ke.getCode());

        ke.consume();
    }

}