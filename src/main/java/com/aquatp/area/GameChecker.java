package com.aquatp.area;

import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;

public class GameChecker {
    private Snake snake;
    private Fruit fruit;
    private CollisionDetector collisionDetector;
    private int score = 0;
    private boolean gameOver;

    public GameChecker(Snake snake, Fruit fruit,Grid grid) {
        this.snake = snake;
        this.fruit = fruit;
        collisionDetector = new CollisionDetector(snake, fruit, grid);
    }

    public void fruitCollisionChecker() {
        if (collisionDetector.scoreChecker()) {
            System.out.println("Score!");
            addScore();
            snake.addToBody();
            fruit.newPosition();
        }
    }

    public void endGame() {
        snake.lockMovement();
    }

    public void startGame() {
        snake.unlockMovement();
    }

    public boolean gameOverChecker() {
        if (collisionDetector.gameOverChecker()) {
            gameOver = true;
            endGame();
            return true;
        }
        return false;
    }

    public void addScore() {
        score++;
    }
}
