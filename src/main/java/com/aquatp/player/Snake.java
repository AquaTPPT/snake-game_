package com.aquatp.player;

import com.aquatp.area.Grid;
import com.aquatp.enums.Direction;
import com.aquatp.factories.SnakeBodyFactory;
import com.aquatp.interfaces.Movable;
import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;


import java.util.ArrayList;
import java.util.List;

import static com.aquatp.area.Grid.CELLSIZE;

public class Snake {
    private SnakeBodyFactory sbf;
    private List<SnakeBodyPart> snakeBodyPart;
    private SnakeHead snakeHead;
    private SnakeMovement movement;

    public Snake(Grid grid) {
        snakeBodyPart = new ArrayList<>();
        movement = new SnakeMovement();
        sbf = new SnakeBodyFactory(grid);
        snakeHead = new SnakeHead(grid);
    }

    // create body parts

    public void addBody() {
        sbf.createBodyPart();
    }

    public void moveSnakeBody() {
        for (SnakeBodyPart sb : snakeBodyPart) {
            sb.move();
        }
    }

    // snake movement

    public void moveHead() {
        switch (movement.getDirection()) {
            case UP -> snakeHead.moveUp();
            case DOWN -> snakeHead.moveDown();
            case LEFT -> snakeHead.moveLeft();
            case RIGHT -> snakeHead.moveRight();
        }
    }

    /*
    * getters and setters
    */
    public List<SnakeBodyPart> getSnakeBody() {
        return snakeBodyPart;
    }

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }

    public Direction getDirection() {
        return movement.getDirection();
    }

    public void setDirection(Direction direction) {
        movement.setDirection(direction);
    }
}
