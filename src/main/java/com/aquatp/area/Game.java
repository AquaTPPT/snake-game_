package com.aquatp.area;

import com.aquatp.controls.KeyboardHandlerImpl;
import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;

public class Game implements Runnable {
    private Grid grid;
    private Snake player;
    private KeyboardHandler k;
    private Fruit fruit;
    private CollisionDetector cd;
    private int score = 0;

    public void init() {
        grid = new Grid(50,30);
        grid.draw();
        player = new Snake(this.grid);
        fruit = new Fruit(this.grid);
        cd = new CollisionDetector(player, fruit);
        k = new KeyboardHandlerImpl(player, fruit);
    }

    public void catchFruitChecker() {
        if (cd.scoreChecker()) {
            score++;
            fruit.newPosition();
        }
    }

    public void gameOverChecker() {
        if (cd.gameOverChecker()) {
            System.exit(0);
        }
    }

    @Override
    public void run() {
        while (true) {
            catchFruitChecker();
            gameOverChecker();
        }
    }
}
