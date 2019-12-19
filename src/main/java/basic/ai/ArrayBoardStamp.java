package basic.ai;

import ai.Exposure;
import ai.Heuristics;
import ai.BoardStamp;
import ai.Track;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class ArrayBoardStamp implements BoardStamp {
    private static final int[] GOAL = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private final int[] board = new int[16];
    private BoardStamp parent = null;

    public ArrayBoardStamp(int[] board) {
        arraycopy(board, 0, this.board, 0, this.board.length);
    }

    @Override
    public void changeParent(BoardStamp parent) {
        if (!this.equals(parent)) this.parent = parent;
    }

    @Override
    public void shareParent(BoardStamp boardStamp) {
        boardStamp.changeParent(parent);
    }

    @Override
    public int countParents() {
        if (null != parent) return 1 + parent.countParents();
        return 0;
    }

    @Override
    public boolean isGoal() {
        return Arrays.equals(board, GOAL);
    }

    @Override
    public int analyze(Heuristics heuristics) {
        return heuristics.calculate(board);
    }

    @Override
    public BoardStamp[] expose(Exposure exposure) {
        BoardStamp[] children = exposure.open(board);
        for (BoardStamp child : children)
            child.changeParent(this);
        return children;
    }

    @Override
    public void pass(Track track) {
        if (null != parent) parent.pass(track);
        track.hold(board);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayBoardStamp that = (ArrayBoardStamp) o;
        return Arrays.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(board);
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        int row = 0;
        for (int i = 0; i < this.board.length; ++i) {
            if (row != i / 4) {
                board.append("\n");
                row = i / 4;
            }
            board.append("\t").append(this.board[i]);
        }
        return board.toString();
    }
}