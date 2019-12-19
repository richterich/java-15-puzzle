package puzzle.decorated;

import puzzle.Initiator;

public abstract class AbstractInitiator implements Initiator {
    private final Initiator initiator;

    protected AbstractInitiator(Initiator initiator) {
        this.initiator = initiator;
    }

    @Override
    public void moveBlank() {
        initiator.moveBlank();
    }
}
