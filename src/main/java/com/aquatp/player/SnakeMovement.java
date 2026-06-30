package com.aquatp.player;

import com.aquatp.enums.Direction;

public class SnakeMovement {
    private Direction direction;

    public SnakeMovement() {
        direction = Direction.RIGHT;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}