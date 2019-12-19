package basic.puzzle;

import puzzle.Blank;

public class ArrayBlank implements Blank {
    private final int[] board;
    private int currentIndex = -1;
    private int goalIndex = -1;

    public ArrayBlank(int[] board) {
        this.board = board;
    }

    @Override
    public void moveRight() {
        if (-1 == currentIndex) currentIndex = findBlank(board);
        if (currentIndex % 4 < 3) {
            goalIndex = 4 * (currentIndex / 4) + (currentIndex % 4 + 1);
            board[currentIndex] = board[goalIndex];
            board[goalIndex] = 0;
            currentIndex = goalIndex;
        }
    }

    @Override
    public void moveLeft() {
        if (-1 == currentIndex) currentIndex = findBlank(board);
        if (currentIndex % 4 > 0) {
            goalIndex = 4 * (currentIndex / 4) + (currentIndex % 4 - 1);
            board[currentIndex] = board[goalIndex];
            board[goalIndex] = 0;
            currentIndex = goalIndex;
        }
    }

    @Override
    public void moveUp() {
        if (-1 == currentIndex) currentIndex = findBlank(board);
        if (currentIndex / 4 > 0) {
            goalIndex = 4 * (currentIndex / 4 - 1) + (currentIndex % 4);
            board[currentIndex] = board[goalIndex];
            board[goalIndex] = 0;
            currentIndex = goalIndex;
        }
    }

    @Override
    public void moveDown() {
        if (-1 == currentIndex) currentIndex = findBlank(board);
        if (currentIndex / 4 < 3) {
            goalIndex = 4 * (currentIndex / 4 + 1) + (currentIndex % 4);
            board[currentIndex] = board[goalIndex];
            board[goalIndex] = 0;
            currentIndex = goalIndex;
        }
    }

    public static int findBlank(int[] board) {
        for (int i = 0; i < board.length; ++i) {
            if (0 == board[i]) {
                 return i;
            }
        }
        return -1;
    }
}
