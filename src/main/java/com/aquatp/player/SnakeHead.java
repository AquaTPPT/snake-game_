package com.aquatp.player;

import com.aquatp.area.Grid;
import com.aquatp.enums.Direction;
import com.aquatp.interfaces.Movable;
import com.codeforall.simplegraphics.graphics.*;
import static com.aquatp.area.Grid.CELLSIZE;
import static com.aquatp.area.Grid.PADDING;

public class SnakeHead implements Movable {
    private Direction direction;
    private Rectangle rectangle;
    private Grid grid;
    private int col, row;

    public SnakeHead(Grid grid) {
        this.grid = grid;
        col = grid.getGridCenterX();
        row = grid.getGridCenterY();
        rectangle = new Rectangle( col * grid.getCellsize() + PADDING, row * grid.getCellsize() + PADDING, CELLSIZE, CELLSIZE);
        rectangle.setColor(Color.ORANGE);
        rectangle.fill();
    }

    @Override
    public void move() {
        switch (direction) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
        }
    }

    @Override
    public void moveUp() {
        rectangle.translate( 0, - grid.getCellsize());
        row--;
    }

    @Override
    public void moveDown() {
        rectangle.translate(0, grid.getCellsize());
        row++;
    }

    @Override
    public void moveLeft() {
        rectangle.translate(-grid.getCellsize(), 0 );
        col--;
    }

    @Override
    public void moveRight() {
        rectangle.translate(grid.getCellsize(), 0 );
        col++;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

}