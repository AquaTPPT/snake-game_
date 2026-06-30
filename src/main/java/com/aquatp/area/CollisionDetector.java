package com.aquatp.area;

import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;
import com.aquatp.player.SnakeBodyPart;

public class CollisionDetector {
    private Snake snake;
    private Fruit fruit;
    private Grid grid;

    public CollisionDetector(Snake snake, Fruit fruit, Grid grid) {
        this.snake = snake;
        this.fruit = fruit;
        this.grid = grid;
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
        if (snake.getSnakeHead().getRow() > grid.getRows() - 1 ||
                snake.getSnakeHead().getRow() < 0 ||
            snake.getSnakeHead().getCol() > grid.getCols() - 1 ||
        snake.getSnakeHead().getCol() < 0) {
            return true;
        }
        for (SnakeBodyPart sb : snake.getSnakeBody()) {
            if (snake.getSnakeHead().getCol() == sb.getCol() &&
            snake.getSnakeHead().getRow() == sb.getRow()) {
                return true;
            }
        }
        return false;
    }

}