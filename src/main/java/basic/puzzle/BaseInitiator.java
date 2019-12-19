package basic.puzzle;

import puzzle.Blank;
import puzzle.Console;
import puzzle.Initiator;

public class BaseInitiator implements Initiator {
    private final Console console;
    private final Blank blank;

    public BaseInitiator(Console console, Blank blank) {
        this.console = console;
        this.blank = blank;
    }

    @Override
    public void moveBlank() {
        switch (console.preferredDirection()) {
            case RIGHT:
                blank.moveRight();
                break;
            case LEFT:
                blank.moveLeft();
                break;
            case UP:
                blank.moveUp();
                break;
            case DOWN:
                blank.moveDown();
                break;
        }
    }
}
