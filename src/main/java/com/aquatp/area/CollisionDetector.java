package com.aquatp.area;

import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;
import com.aquatp.player.SnakeBodyPart;

public class CollisionDetector {
    private Snake snake;
    private Fruit fruit;

    public CollisionDetector(Snake snake, Fruit fruit) {
        this.snake = snake;
        this.fruit = fruit;
    }

    public boolean scoreChecker() {
            if (snake.getSnakeHead().getCol() == fruit.getCol() &&
                    snake.getSnakeHead().getRow() == fruit.getRow()) {
                System.out.println("score!");
                return true;
            }
            return false;
    }

    public boolean gameOverChecker() {
        for (SnakeBodyPart sb : snake.getSnakeBody()) {
            if (snake.getSnakeHead().getCol() == sb.getCol() &&
            snake.getSnakeHead().getRow() == sb.getRow()) {
                return true;
            }
        }
        return false;
    }

}
