package com.aquatp.factories;

import com.aquatp.area.Grid;
import com.aquatp.player.SnakeBodyPart;

public class SnakeBodyFactory {
    private Grid grid;

    public SnakeBodyFactory(Grid grid) {
        this.grid = grid;
    }

    public SnakeBodyPart createBodyPart() {
        return new SnakeBodyPart(grid);
    }
}
