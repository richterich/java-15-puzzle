package basic.puzzle;

import puzzle.Console;
import puzzle.Sensor;

public class BaseConsole implements Console {
    private final Sensor sensor;

    public BaseConsole(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public Direction preferredDirection() {
        switch (sensor.respond()) {
            case 1000:
                return Direction.DOWN;
            case 1100:
                return Direction.RIGHT;
            case 1110:
                return Direction.UP;
            case 1111:
                return Direction.LEFT;
            default:
                return Direction.NONE;
        }
    }
}
