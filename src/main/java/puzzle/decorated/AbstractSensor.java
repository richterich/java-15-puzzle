package puzzle.decorated;

import puzzle.Sensor;

public abstract class AbstractSensor implements Sensor {
    private final Sensor sensor;

    protected AbstractSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void listen() {
        sensor.listen();
    }

    @Override
    public int respond() {
        return sensor.respond();
    }
}
