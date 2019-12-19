package basic.puzzle;

import basic.Ambulance;
import puzzle.Game;
import puzzle.GameState;
import puzzle.Sensor;

public class BaseState implements GameState {
    private static final int AMBULANCE = 1;
    private static final int EXIT = 0;
    private static final int NEW_GAME = 5;
    private final Sensor sensor;
    private final Ambulance ambulance;

    public BaseState(Sensor sensor, Ambulance ambulance) {
        this.sensor = sensor;
        this.ambulance = ambulance;
    }

    @Override
    public void updateState(Game game) {
        switch (sensor.respond()) {
            case NEW_GAME:
                game.load();
                break;
            case EXIT:
                game.unload();
                break;
            case AMBULANCE:
                ambulance.assist();
                break;
        }
    }
}
