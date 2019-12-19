package puzzle.decorated;

import puzzle.Game;
import puzzle.GameWorld;

public abstract class AbstractGameWorld implements GameWorld {
    private final GameWorld gameWorld;

    protected AbstractGameWorld(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void renderWorld(Game game) {
        gameWorld.renderWorld(game);
    }
}
