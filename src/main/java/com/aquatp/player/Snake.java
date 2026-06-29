package com.aquatp.player;

import com.aquatp.area.Grid;
import com.aquatp.factories.SnakeBodyFactory;
import com.aquatp.interfaces.Movable;
import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;


import java.util.ArrayList;
import java.util.List;

import static com.aquatp.area.Grid.CELLSIZE;
import static com.aquatp.area.Grid.PADDING;

public class Snake implements Movable {
    private SnakeBodyFactory sbf;
    private List<SnakeBody> snakeBody;
    private Rectangle snakeHead;
    private Grid grid;
    private int xPos, yPos;

    public Snake(Grid grid) {
        this.grid = grid;

        xPos = grid.getGridCenterX();
        yPos = grid.getGridCenterY();

        snakeBody = new ArrayList<>();

        sbf = new SnakeBodyFactory();
        snakeHead = new Rectangle( grid.getGridCenterX(), grid.getGridCenterY(), CELLSIZE, CELLSIZE);
        snakeHead.setColor(Color.ORANGE);
        snakeHead.fill();
    }

    // create body parts

    public void addSnakeBody() {
        snakeBody.add(sbf.createBodyPart());
    }

    // snake movement

    @Override
    public void moveUp() {
        snakeHead.translate( 0, - grid.getCellsize());
        --yPos;
    }

    @Override
    public void moveDown() {
        snakeHead.translate(0, grid.getCellsize());
        ++yPos;
    }

    @Override
    public void moveLeft() {
        snakeHead.translate(-grid.getCellsize(), 0 );
    }

    @Override
    public void moveRight() {
        snakeHead.translate(grid.getCellsize(), 0 );
    }

    // getter

    public List<SnakeBody> getSnakeBody() {
        return snakeBody;
    }

    public Rectangle getSnakeHead() {
        return snakeHead;
    }
}
