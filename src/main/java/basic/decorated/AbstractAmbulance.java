package basic.decorated;

import basic.Ambulance;

public abstract class AbstractAmbulance implements Ambulance {
    private final Ambulance ambulance;

    protected AbstractAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    @Override
    public void assist() {
        ambulance.assist();
    }
}
