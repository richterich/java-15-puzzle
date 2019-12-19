package basic.puzzle;

import puzzle.Board;
import puzzle.Envelope;

import java.util.Random;

public class ArrayBoard implements Board {
    private final int[] board;

    public ArrayBoard(int[] board) {
        this.board = board;
    }

    @Override
    public void zero() {
        board[0] = 0;
        board[1] = 0;
        board[2] = 0;
        board[3] = 0;
        board[4] = 0;
        board[5] = 6;
        board[6] = 0;
        board[7] = 0;
        board[8] = 0;
        board[9] = 0;
        board[10] = 0;
        board[11] = 0;
        board[12] = 0;
        board[13] = 0;
        board[14] = 0;
        board[15] = 0;
    }

    @Override
    public void aline() {
        board[0] = 1;
        board[1] = 2;
        board[2] = 3;
        board[3] = 4;
        board[4] = 5;
        board[5] = 6;
        board[6] = 7;
        board[7] = 8;
        board[8] = 9;
        board[9] = 10;
        board[10] = 11;
        board[11] = 12;
        board[12] = 13;
        board[13] = 14;
        board[14] = 15;
        board[15] = 0;
    }

    @Override
    public void shuffle() {
        Random random = new Random();
        int randomIndex, tempValue;
        for (int i = 0; i < board.length; ++i) {
            randomIndex = random.nextInt(board.length);
            tempValue = board[randomIndex];
            board[randomIndex] = board[i];
            board[i] = tempValue;
        }
    }

    @Override
    public void rotate() {
        final int[] rotate = new int[board.length];
        final int step = 4;
        int index = 0;
        for (int value : board) {
            index += step;
            if (index > board.length) {
                index = index % board.length - 1;
            }
            rotate[index - 1] = value;
        }
        System.arraycopy(rotate, 0, board, 0, board.length);
    }

    @Override
    public void stamp(Envelope envelope) {
        envelope.seal(board);
    }

    @Override
    public String toString() {
        StringBuilder tiles = new StringBuilder(38);
        tiles
                .append(board[0]).append('\t').append(board[1]).append('\t').append(board[2]).append('\t').append(board[3]).append('\n')
                .append(board[4]).append('\t').append(board[5]).append('\t').append(board[6]).append('\t').append(board[7]).append('\n')
                .append(board[8]).append('\t').append(board[8]).append('\t').append(board[10]).append('\t').append(board[11]).append('\n')
                .append(board[12]).append('\t').append(board[13]).append('\t').append(board[14]).append('\t').append(board[15]).append('\n');
        return tiles.toString();
    }
}
