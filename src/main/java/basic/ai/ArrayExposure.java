package basic.ai;

import ai.Exposure;
import ai.BoardStamp;

import static java.lang.System.arraycopy;

public class ArrayExposure implements Exposure {
    @Override
    public BoardStamp[] open(int[] boardStamp) {
        final int blankIndex = searchSpace(boardStamp);
        int length = countStamp(blankIndex);
        final BoardStamp[] boardStamps = new BoardStamp[length];
        int tileIndex;
        if (blankIndex % 4 < 3) {// right
            tileIndex = 4 * (blankIndex / 4) + (blankIndex % 4 + 1);
            boardStamps[boardStamps.length - length] = new ArrayBoardStamp(swap(boardStamp, blankIndex, tileIndex));
            --length;
        }
        if (blankIndex % 4 > 0) {//left
            tileIndex = 4 * (blankIndex / 4) + (blankIndex % 4 - 1);
            boardStamps[boardStamps.length - length] = new ArrayBoardStamp(swap(boardStamp, blankIndex, tileIndex));
            --length;
        }
        if (blankIndex / 4 > 0) {//up
            tileIndex = 4 * (blankIndex / 4 - 1) + (blankIndex % 4);
            boardStamps[boardStamps.length - length] = new ArrayBoardStamp(swap(boardStamp, blankIndex, tileIndex));
            --length;
        }
        if (blankIndex / 4 < 3) {//down
            tileIndex = 4 * (blankIndex / 4 + 1) + (blankIndex % 4);
            boardStamps[boardStamps.length - length] = new ArrayBoardStamp(swap(boardStamp, blankIndex, tileIndex));
            --length;
        }
        return boardStamps;
    }

    private static int[] swap(int[] board, int blankIndex, int tileIndex) {
        final int[] stamp = new int[board.length];
        arraycopy(board, 0, stamp, 0, board.length);
        stamp[blankIndex] = board[tileIndex];
        stamp[tileIndex] = 0;
        return stamp;
    }

    private static int searchSpace(int[] board) {
        for (int i = 0; i < board.length; ++i) {
            if (0 == board[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int countStamp(int spaceIndex) {
        int numberOfStamp = 0;
        if (spaceIndex % 4 < 3) {
            ++numberOfStamp;
        }
        if (spaceIndex % 4 > 0) {
            ++numberOfStamp;
        }
        if (spaceIndex / 4 < 3) {
            ++numberOfStamp;
        }
        if (spaceIndex / 4 > 0) {
            ++numberOfStamp;
        }
        return numberOfStamp;
    }
}
