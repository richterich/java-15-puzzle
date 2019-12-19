package puzzle.decorated;

import puzzle.Turn;

public abstract class AbstractTurn implements Turn {
    private final Turn turn;

    protected AbstractTurn(Turn turn) {
        this.turn = turn;
    }

    @Override
    public void ask() {
        turn.ask();
    }

    @Override
    public boolean canAsk() {
        return turn.canAsk();
    }
}
