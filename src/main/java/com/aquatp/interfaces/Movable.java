package com.aquatp.interfaces;

import com.aquatp.enums.Direction;

public interface Movable {

    void move();

    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    Direction getDirection();

    void setDirection(Direction direction);
}
