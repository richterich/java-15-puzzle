package basic.puzzle;

import puzzle.*;

public class BaseGameLoop implements GameLoop {
    private static final int EXIT = 0;
    private final Game game;
    private final Sensor sensor;
    private final GameInput gameInput;
    private final GameState gameState;
    private final GameWorld gameWorld;

    public BaseGameLoop(Game game, Sensor sensor, GameInput gameInput, GameState gameState, GameWorld gameWorld) {
        this.game = game;
        this.sensor = sensor;
        this.gameInput = gameInput;
        this.gameState = gameState;
        this.gameWorld = gameWorld;
    }

    @Override
    public void start() {
        do {
            gameInput.handleInput(sensor);
            gameState.updateState(game);
            gameWorld.renderWorld(game);
        } while (EXIT != sensor.respond());
    }
}
