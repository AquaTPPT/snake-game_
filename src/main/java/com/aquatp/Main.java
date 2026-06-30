package com.aquatp;

import com.aquatp.area.Game;
import com.aquatp.area.GameChecker;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.init();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
            executorService.submit(game);

    }

}
