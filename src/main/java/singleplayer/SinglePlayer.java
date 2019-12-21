package singleplayer;

import basic.SentBoard;
import basic.Envelope;
import puzzle.Game;
import puzzle.decorated.AbstractGame;

public class SinglePlayer extends AbstractGame {
    protected final SentBoard sentBoard;
    private final Envelope envelope;

    public SinglePlayer(Game game, SentBoard sentBoard, Envelope envelope) {
        super(game);
        this.sentBoard = sentBoard;
        this.envelope = envelope;
    }

    @Override
    public void load() {
        super.load();
        sentBoard.stamp(envelope);
    }
}
