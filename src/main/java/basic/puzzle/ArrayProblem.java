package basic.puzzle;

import puzzle.Problem;

public class ArrayProblem implements Problem {
    private final int[] board;

    public ArrayProblem(int[] board) {
        this.board = board;
    }

    @Override
    public boolean isSolvable() {
        return 0 == (countInversions() - findEmpty()) % 2;
    }

    private int countInversions() {
        int inversions = 0;
        for (int i = 0; i < board.length; ++i) {
            if (0 != board[i]) {
                for (int j = 0; j < i; ++j) {
                    if (board[j] > board[i]) {
                        ++inversions;
                    }
                }
            }
        }
        return inversions;
    }

    private int findEmpty() {
        int line = -1;
        for (int i = 0; i < board.length; ++i) {
            if (0 == board[i]) {
                line = 1 + i / 4;
            }
        }
        return line;
    }
}
