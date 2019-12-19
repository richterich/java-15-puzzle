package ai;

public interface Pathfinder {
    boolean isDone();
    boolean canFind();
    void findNext();
    Track lead();
}
