package com.aquatp.controls;

import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;
import com.codeforall.simplegraphics.keyboard.*;

import java.awt.event.KeyEvent;

public class KeyboardHandlerImpl implements KeyboardHandler {
    private Snake snake;
    private Keyboard k;
    private Fruit fruit;

    public KeyboardHandlerImpl(Snake snake, Fruit fruit) {
        this.fruit = fruit;
        this.snake = snake;
        this.k = new Keyboard(this);

        KeyboardEvent goUp = new KeyboardEvent();
        goUp.setKey(KeyboardEvent.KEY_I);
        goUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent goDown = new KeyboardEvent();
        goDown.setKey(KeyboardEvent.KEY_S);
        goDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent goLeft = new KeyboardEvent();
        goLeft.setKey(KeyboardEvent.KEY_A);
        goLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent goRight = new KeyboardEvent();
        goRight.setKey(KeyboardEvent.KEY_D);
        goRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(goUp);
        k.addEventListener(goDown);
        k.addEventListener(goLeft);
        k.addEventListener(goRight);

        // For testing purposes

        KeyboardEvent changeFruitPosition = new KeyboardEvent();
        changeFruitPosition.setKey(KeyboardEvent.KEY_J);
        changeFruitPosition.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(changeFruitPosition);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_I -> snake.moveUp();
            case KeyboardEvent.KEY_S -> snake.moveDown();
            case KeyboardEvent.KEY_A -> snake.moveLeft();
            case KeyboardEvent.KEY_D -> snake.moveRight();
            // For testing purposes - remove later!
            case KeyboardEvent.KEY_J -> fruit.newPosition();
        }
        System.out.println("pressed a key: " + e.getKey());
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
