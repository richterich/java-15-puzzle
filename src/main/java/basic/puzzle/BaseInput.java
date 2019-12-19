package basic.puzzle;

import puzzle.GameInput;
import puzzle.Sensor;

public class BaseInput implements GameInput {
    @Override
    public void handleInput(Sensor sensor) {
        sensor.listen();
    }
}
