package com.aquatp.objects;

import com.aquatp.area.Grid;
import com.aquatp.statics.Random;
import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

import static com.aquatp.area.Grid.PADDING;


public class Fruit {
    private Rectangle rectangle;
    private Grid grid;
    private int col, row;

    public Fruit(Grid grid) {
        this.grid = grid;
        newGridPosition();
        rectangle = new Rectangle(
            col * grid.getCellsize() + PADDING,
            row * grid.getCellsize() + PADDING,
            grid.getCellsize(), grid.getCellsize());
        rectangle.setColor(Color.RED);
        rectangle.fill();
    }

    public void newPosition() {
        int oldCol = col;
        int oldRow = row;
        newGridPosition();
        rectangle.translate(
        -(oldCol - col) * grid.getCellsize(),
        -(oldRow - row) * grid.getCellsize());
    }

    private void newGridPosition() {
        col = Random.random(0, grid.getCols());
        row = Random.random(0,grid.getRows());
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    
}
