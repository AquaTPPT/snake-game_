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
    private List<SnakeBodyPart> snakeBodyParts;
    private SnakeHead snakeHead;

    public Snake(Grid grid) {
        snakeBodyParts = new ArrayList<>();
        sbf = new SnakeBodyFactory(grid);
        snakeHead = new SnakeHead(grid);
        snakeHead.setDirection(Direction.RIGHT);
        createStartingBody(grid);
    }

    public void createStartingBody(Grid grid) {
        SnakeBodyPart sbp = sbf.createBodyPart();
        snakeBodyParts.add(sbp);
        snakeBodyParts.getFirst().setCurrentDirection(Direction.RIGHT);
        snakeBodyParts.getFirst().spawnStarter(grid.getGridCenterX(),grid.getGridCenterY());
        snakeBodyParts.getFirst().moveLeft();
        for (int i = 1; i <= 3; i++) {
            addToBody();
        }
    }

    // create body parts

    public void addToBody() {
        SnakeBodyPart sbp = sbf.createBodyPart();
        sbp.setCurrentDirection(snakeBodyParts.getLast().getCurrentDirection());
        sbp.spawn(snakeBodyParts.getLast().getCol(), snakeBodyParts.getLast().getRow());
        switch (sbp.getCurrentDirection()) {
            case UP -> sbp.moveDown();
            case DOWN -> sbp.moveUp();
            case LEFT -> sbp.moveRight();
            case RIGHT -> sbp.moveLeft();
        }
        snakeBodyParts.add(sbp);
    }

    public void moveSnakeBody() {
        snakeBodyParts.getFirst().setNextDirection(snakeHead.getDirection());
   //     System.out.println("Snakehead direction: " + snakeHead.getDirection());
        snakeBodyParts.getFirst().move();
        for (int i = 1; i < snakeBodyParts.size(); i++) {
   //         System.out.println("X: " + snakeBodyParts.get(i).getCol() + " Y: " + snakeBodyParts.get(i).getRow());
            snakeBodyParts.get(i).setNextDirection(snakeBodyParts.get(i - 1).getCurrentDirection());
            snakeBodyParts.get(i).move();
   //         System.out.println("Body part direction: " + snakeBodyParts.get(i).getCurrentDirection());
        }
        updateDirections();
    }

    public void updateDirections() {
        for (SnakeBodyPart sbp : snakeBodyParts) {
            sbp.updateDirection();
        }
    }
    // snake movement

    public void moveHead() {
        switch (snakeHead.getDirection()) {
            case UP -> snakeHead.moveUp();
            case DOWN -> snakeHead.moveDown();
            case LEFT -> snakeHead.moveLeft();
            case RIGHT -> snakeHead.moveRight();
        }
    //    System.out.println("Head X: " + snakeHead.getCol() + " Y: " + snakeHead.getRow());
    }

    public void lockMovement() {
        snakeHead.setDirection(Direction.NONE);
    }

    public void unlockMovement() {
        snakeHead.setDirection(Direction.RIGHT);
    }

    /*
    * getters and setters
    */
    public List<SnakeBodyPart> getSnakeBody() {
        return snakeBodyParts;
    }

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }
}
