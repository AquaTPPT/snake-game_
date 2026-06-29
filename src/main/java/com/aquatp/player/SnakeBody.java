package com.aquatp.player;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

import static com.aquatp.area.Grid.CELLSIZE;

public class SnakeBody {
    private Rectangle body;
    private int currentX, currentY;

    public SnakeBody() {
        body = new Rectangle();
        body.grow(CELLSIZE, CELLSIZE);
        body.setColor(Color.BLUE);
        body.fill();
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

}
