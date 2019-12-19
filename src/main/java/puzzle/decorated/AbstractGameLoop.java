package puzzle.decorated;

import puzzle.GameLoop;

public abstract class AbstractGameLoop implements GameLoop {
    private final GameLoop gameLoop;

    protected AbstractGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    @Override
    public void start() {
        gameLoop.start();
    }
}
