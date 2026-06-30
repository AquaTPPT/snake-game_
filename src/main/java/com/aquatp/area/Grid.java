package com.aquatp.area;

import com.codeforall.simplegraphics.graphics.*;


public class Grid {
    private Rectangle grid;

    public static final int PADDING = 10;

    private int cols;
    private int rows;
    public static final int CELLSIZE = 15;


    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        grid = new Rectangle(PADDING, PADDING, cols * CELLSIZE, rows * CELLSIZE);
    }

    public void draw() {
        grid.draw();
    }

    public Rectangle getGrid() {
        return grid;
    }

    public int getCellsize() {return CELLSIZE; }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int rowToX() { return cols * CELLSIZE; }

    public int colToY() { return rows * CELLSIZE; }

    public int getGridCenterX() {
        return cols / 2;
    }

    public int getGridCenterY() {
        return rows / 2;
    }
}
