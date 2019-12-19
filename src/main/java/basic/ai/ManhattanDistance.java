package basic.ai;

import ai.Heuristics;

public class ManhattanDistance implements Heuristics {
    @Override
    public int calculate(int[] board) {
        int manhattan = 0, expectedRow, expectedCol, actualRow, actualCol;
        for (int i = 0; i < board.length; ++i) {
            if (0 == board[i]) continue;
            expectedRow = (i / 4) + 1;
            expectedCol = (i % 4) + 1;
            actualRow = ((board[i] - 1) / 4) + 1;
            actualCol = ((board[i] - 1) % 4) + 1;
            manhattan += Math.abs(expectedRow - actualRow) + Math.abs(expectedCol - actualCol);
        }
        return manhattan;
    }
}
