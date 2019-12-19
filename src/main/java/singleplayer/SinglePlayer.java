package singleplayer;

import puzzle.Board;
import puzzle.Envelope;
import puzzle.Game;
import puzzle.decorated.AbstractGame;

public class SinglePlayer extends AbstractGame {
    protected final Board board;
    private final Envelope envelope;

    public SinglePlayer(Game game, Board board, Envelope envelope) {
        super(game);
        this.board = board;
        this.envelope = envelope;
    }

    @Override
    public void load() {
        super.load();
        board.stamp(envelope);
    }
}
