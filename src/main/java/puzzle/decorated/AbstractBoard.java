package puzzle.decorated;

import puzzle.Board;

public abstract class AbstractBoard implements Board {
    private final Board board;

    protected AbstractBoard(Board board) {
        this.board = board;
    }

    @Override
    public void zero() {
        board.zero();
    }

    @Override
    public void aline() {
        board.aline();
    }

    @Override
    public void shuffle() {
        board.shuffle();
    }

    @Override
    public void rotate() {
        board.rotate();
    }
}
