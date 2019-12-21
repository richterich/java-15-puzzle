package basic;

import basic.puzzle.ArrayBoard;

public class ArraySentBoard extends ArrayBoard implements SentBoard {
    private final int[] board;

    public ArraySentBoard(int[] board) {
        super(board);
        this.board = board;
    }

    @Override
    public void stamp(Envelope envelope) {
        envelope.seal(board);
    }
}
