package basic.decorated;

import basic.Envelope;

public abstract class AbstractEnvelope implements Envelope {
    private final Envelope envelope;

    protected AbstractEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    @Override
    public void seal(int[] board) {
        envelope.seal(board);
    }

    @Override
    public int[] reveal() {
        return envelope.reveal();
    }
}
