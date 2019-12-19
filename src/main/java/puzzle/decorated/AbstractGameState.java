package puzzle.decorated;

import puzzle.Game;
import puzzle.GameState;

public abstract class AbstractGameState implements GameState {
    private final GameState gameState;

    protected AbstractGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void updateState(Game game) {
        gameState.updateState(game);
    }
}
