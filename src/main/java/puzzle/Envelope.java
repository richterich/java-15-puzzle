package puzzle;

public interface Envelope {
    void seal(int[] board);

    int[] reveal();
}
