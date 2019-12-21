package basic;

import ai.Pathfinder;
import basic.ai.ArrayBoardStamp;
import basic.ai.ArrayPathfinder;
import basic.ai.ArrayTrack;

public class ArrayAmbulance implements Ambulance {
    private final Envelope envelope;
    private Pathfinder pathfinder;

    public ArrayAmbulance(Envelope envelope) {
        this.envelope = envelope;
    }

    @Override
    public void assist() {
        pathfinder = new ArrayPathfinder(new ArrayBoardStamp(envelope.reveal()), new ArrayTrack());
        do {
            pathfinder.findNext();
            if (pathfinder.isDone()) {
                pathfinder
                        .lead()
                        .show();
                break;
            }
        } while (pathfinder.canFind());
    }
}
