package com.aquatp.player;

import com.aquatp.area.Grid;
import com.aquatp.enums.Direction;
import com.aquatp.interfaces.Movable;
import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

import static com.aquatp.area.Grid.CELLSIZE;

public class SnakeBodyPart implements Movable {
    private Rectangle body;
    private Grid grid;
    private int col, row;
    private Direction direction;

    public SnakeBodyPart(Grid grid) {
        this.grid = grid;
        spawn();
    }

    private void spawn() {
        body = new Rectangle();
        body.grow(CELLSIZE, CELLSIZE);
        body.setColor(Color.BLUE);
        body.fill();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
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
        body.translate( 0, - grid.getCellsize());
        row--;
    }

    @Override
    public void moveDown() {
        body.translate(0, grid.getCellsize());
        row++;
    }

    @Override
    public void moveLeft() {
        body.translate(-grid.getCellsize(), 0 );
        col--;
    }

    @Override
    public void moveRight() {
        body.translate(grid.getCellsize(), 0 );
        col++;
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
