package com.aquatp.player;

import com.aquatp.area.Grid;
import com.aquatp.enums.Direction;
import com.aquatp.interfaces.Movable;
import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

import java.io.InvalidObjectException;

import static com.aquatp.area.Grid.CELLSIZE;
import static com.aquatp.area.Grid.PADDING;

public class SnakeBodyPart implements Movable {
    private Rectangle body;
    private Grid grid;
    private int col, row;
    private Direction currentDirection, nextDirection;

    public SnakeBodyPart(Grid grid) {
        this.grid = grid;
    }

    public void spawnStarter(int col, int row) {
        body = new Rectangle(col * CELLSIZE + PADDING, row * CELLSIZE + PADDING, CELLSIZE, CELLSIZE);
        setCol(col);
        setRow(row);
        body.setColor(Color.BLUE);
        body.fill();
    }

    public void spawn(int col, int row) {
        body = new Rectangle(col * CELLSIZE + PADDING, row * CELLSIZE + PADDING, CELLSIZE, CELLSIZE);
        setCol(col);
        setRow(row);
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
    public void move() throws IllegalArgumentException {
        switch (currentDirection) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            case null -> System.out.println("Movement is null!");
            case NONE -> System.out.println("Movement is NONE! ");
        }
    }

    public void updateDirection() {
        currentDirection = nextDirection;
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

    public Direction getNextDirection() {
        return nextDirection;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    public void setNextDirection(Direction direction) {
        this.nextDirection = direction;
    }
}
