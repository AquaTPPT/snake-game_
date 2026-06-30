package com.aquatp.area;

import com.aquatp.controls.KeyboardHandlerImpl;
import com.aquatp.objects.Fruit;
import com.aquatp.player.Snake;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Game implements Runnable {
    private Grid grid;
    private Snake player;
    private KeyboardHandler k;
    private GameChecker gameChecker;
    private Fruit fruit;

    public void init() {
        grid = new Grid(50,20);
        grid.draw();
        player = new Snake(this.grid);
        fruit = new Fruit(this.grid);
        gameChecker = new GameChecker(player, fruit);
        k = new KeyboardHandlerImpl(player, fruit);
    }

    @Override
    public void run() {
        System.out.println("hi!");
        while (true) {
            try {
                player.moveHead();
                gameChecker.fruitCollisionChecker();
                gameChecker.gameOverChecker();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
