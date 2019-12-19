package puzzle.decorated;

import puzzle.Console;

public abstract class AbstractConsole implements Console {
    private final Console console;

    protected AbstractConsole(Console console) {
        this.console = console;
    }

    @Override
    public Direction preferredDirection() {
        return console.preferredDirection();
    }
}
