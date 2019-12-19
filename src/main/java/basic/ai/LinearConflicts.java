package basic.ai;

import ai.Heuristics;
import ai.decorated.AbstractHeuristics;

public class LinearConflicts extends AbstractHeuristics {

    public LinearConflicts(Heuristics heuristics) {
        super(heuristics);
    }

    @Override
    public int calculate(int[] board) {
        // Horizontal
        int conflicts = 0, expectedTj, expectedTk, positionTj, positionTk, goalTj, goalTk;
        for (int i = 0; i < board.length; i += 4) {
            for (int j = i; j < i + 4 - 1; ++j) {
                if (0 == board[j]) continue;
                positionTj = j / 4;
                goalTj = ((board[j] - 1) / 4);
                expectedTj = ((board[j] - 1) % 4);
                for (int k = j + 1; k < i + 4; ++k) {
                    if (0 == board[k]) continue;
                    positionTk = k / 4;
                    goalTk = ((board[k] - 1) / 4);
                    expectedTk = ((board[k] - 1) % 4);
                    if (positionTj == goalTj && positionTk == goalTk) {
                        if (0 > expectedTk - expectedTj) {
                            ++conflicts;
                        }
                    }
                }
            }
        }
        // Vertical
        for (int i = 0; i < board.length / 4; ++i) {
            for (int j = i; j < board.length; j += 4) {
                if (0 == board[j]) continue;
                positionTj = j % 4;
                goalTj = ((board[j] - 1) % 4);
                expectedTj = ((board[j] - 1) / 4);
                for (int k = j + 4; k < board.length; k += 4) {
                    if (0 == board[k]) continue;
                    positionTk = k % 4;
                    goalTk = ((board[k] - 1) % 4);
                    expectedTk = ((board[k] - 1) / 4);
                    if (positionTj == goalTj && positionTk == goalTk) {
                        if (0 > expectedTk - expectedTj) {
                            ++conflicts;
                        }
                    }
                }
            }
        }
        conflicts *= 2;
        return conflicts + super.calculate(board);
    }
}
