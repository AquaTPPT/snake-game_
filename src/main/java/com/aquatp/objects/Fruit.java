package com.aquatp.objects;

import com.aquatp.area.Grid;
import com.aquatp.statics.Random;
import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

import static com.aquatp.area.Grid.PADDING;


public class Fruit {
    private Rectangle rectangle;
    private Grid grid;
    private int xPos, yPos;

    public Fruit(Grid grid) {
        this.grid = grid;
        rectangle = new Rectangle(
            (Random.random(PADDING, (grid.getCols() - 1) * grid.getCellsize()) / grid.getCellsize()) * grid.getCellsize(),
            (Random.random(PADDING, (grid.getRows() - 1) * grid.getCellsize()) / grid.getCellsize()) * grid.getCellsize(),
            grid.getCellsize(), grid.getCellsize());
        rectangle.setColor(Color.RED);
        rectangle.fill();
        xPos = rectangle.getX();
        yPos = rectangle.getY();
    }

    public void newPosition() {

        rectangle.translate(
        (Random.random(PADDING, (grid.getCols() - 1) * grid.getCellsize()) / grid.getCellsize()) * grid.getCellsize() - rectangle.getX(),
        (Random.random(PADDING, (grid.getRows() - 1) * grid.getCellsize()) / grid.getCellsize()) * grid.getCellsize() - rectangle.getY());

        registerPosition();<
    }

    private void registerPosition() {
        xPos = rectangle.getX();
        yPos = rectangle.getY();
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    
}
