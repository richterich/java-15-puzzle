package puzzle.decorated;

import puzzle.Attempts;

public abstract class AbstractAttempts implements Attempts {
    private final Attempts attempts;

    protected AbstractAttempts(Attempts attempts) {
        this.attempts = attempts;
    }

    @Override
    public void useOne() {
        attempts.useOne();
    }

    @Override
    public boolean have() {
        return attempts.have();
    }
}
