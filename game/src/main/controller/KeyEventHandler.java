package main.controller;

import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

public class KeyEventHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent ke) {

        System.out.println(ke.getCode());
        //if (ke.getCode() == KeyCode.ENTER) {}

        ke.consume();
    }
}