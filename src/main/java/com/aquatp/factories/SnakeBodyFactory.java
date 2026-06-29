package com.aquatp.factories;

import com.aquatp.player.SnakeBody;

public class SnakeBodyFactory {

    public SnakeBody createBodyPart() {
        return new SnakeBody();
    }

}
