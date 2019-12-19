package basic.puzzle;

import puzzle.Inspector;

public class ArrayInspector implements Inspector {
    private final int[] board;

    public ArrayInspector(int[] board) {
        this.board = board;
    }

    @Override
    public boolean isCollected() {
        for (int i = 0; i < board.length - 2; ++i) {
            if (1 != board[i + 1] - board[i]) {
                return false;
            }
        }
        return true;
    }
}
