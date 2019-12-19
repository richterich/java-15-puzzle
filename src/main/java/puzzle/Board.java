package puzzle;

public interface Board {
    void zero();

    void aline();

    void shuffle();

    void rotate();

    void stamp(Envelope envelope);
}
