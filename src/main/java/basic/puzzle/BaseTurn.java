package basic.puzzle;

import puzzle.Attempts;
import puzzle.Initiator;
import puzzle.Inspector;
import puzzle.Turn;

public class BaseTurn implements Turn {
    private final Initiator initiator;
    private final Inspector inspector;
    private final Attempts attempts;

    public BaseTurn(Initiator initiator, Inspector inspector, Attempts attempts) {
        this.initiator = initiator;
        this.inspector = inspector;
        this.attempts = attempts;
    }

    @Override
    public void ask() {
        attempts.useOne();
        initiator.moveBlank();
    }

    @Override
    public boolean canAsk() {
        return !inspector.isCollected() && attempts.have();
    }
}
