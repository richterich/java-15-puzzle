package puzzle.decorated;

import puzzle.Blank;

public abstract class AbstractBlank implements Blank {
    private final Blank blank;

    protected AbstractBlank(Blank blank) {
        this.blank = blank;
    }

    @Override
    public void moveRight() {
        blank.moveRight();
    }

    @Override
    public void moveLeft() {
        blank.moveLeft();
    }

    @Override
    public void moveUp() {
        blank.moveUp();
    }

    @Override
    public void moveDown() {
        blank.moveDown();
    }
}
