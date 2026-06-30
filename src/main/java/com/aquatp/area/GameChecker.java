package com.aquatp.area;

import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;

public class GameChecker {
    private Snake snake;
    private Fruit fruit;
    private CollisionDetector collisionDetector;
    private int score = 0;

    public GameChecker(Snake snake, Fruit fruit) {
        this.snake = snake;
        this.fruit = fruit;
        collisionDetector = new CollisionDetector(snake, fruit);
    }

    public void fruitCollisionChecker() {
        if (collisionDetector.scoreChecker()) {
            System.out.println("Score!");
            addScore();
            fruit.newPosition();
        }
    }

    public void gameOverChecker() {
        if (collisionDetector.gameOverChecker()) {

        }
    }

    public void addScore() {
        score++;
    }
}
