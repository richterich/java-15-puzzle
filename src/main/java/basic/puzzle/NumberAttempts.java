package basic.puzzle;

import puzzle.Attempts;

public class NumberAttempts implements Attempts {
    private int number;

    public NumberAttempts(int number) {
        this.number = number;
    }

    @Override
    public void useOne() {
        if (0 < number) {
            --number;
        }
    }

    @Override
    public boolean have() {
        if (-1 == number) {
            return true;
        }
        return 0 < number;
    }
}
