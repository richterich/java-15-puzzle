package basic;

public class ArrayEnvelope implements Envelope {
    private final int[] boardStamp = new int[16];

    @Override
    public void seal(int[] board) {
        System.arraycopy(board, 0, boardStamp, 0, boardStamp.length);
    }

    @Override
    public int[] reveal() {
        return boardStamp;
    }
}
