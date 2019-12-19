package puzzle.decorated;

import puzzle.Game;

public abstract class AbstractGame implements Game {
    private final Game game;

    protected AbstractGame(Game game) {
        this.game = game;
    }

    @Override
    public void unload() {
        game.unload();
    }

    @Override
    public void load() {
        game.load();
    }

    @Override
    public void play() {
        game.play();
    }
}
