package basic.puzzle;

import puzzle.Game;
import puzzle.GameWorld;

public class BaseWorld implements GameWorld {
    @Override
    public void renderWorld(Game game) {
        game.play();
    }
}
