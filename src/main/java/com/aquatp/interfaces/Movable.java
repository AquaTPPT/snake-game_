package com.aquatp.interfaces;

import com.aquatp.enums.Direction;

public interface Movable {

    void move() throws IllegalArgumentException;

    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

}
