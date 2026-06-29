package com.aquatp.area;

import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;
import com.aquatp.player.SnakeBody;

public class CollisionDetector {
    private Snake snake;
    private Fruit fruit;

    public CollisionDetector(Snake snake, Fruit fruit) {
        this.snake = snake;
        this.fruit = fruit;
    }

    public boolean scoreChecker() {
        if (snake.getSnakeHead().getX() == fruit.getX() &&
            snake.getSnakeHead().getY() == fruit.getY()) {
            return true;
        }
        return false;
    }

    public boolean gameOverChecker() {
        for (SnakeBody sb : snake.getSnakeBody()) {
            if (snake.getSnakeHead().getX() == sb.getCurrentX() &&
            snake.getSnakeHead().getY() == sb.getCurrentY()) {
                return true;
            }
        }
        return false;
    }
}
