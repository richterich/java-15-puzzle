package ai;

public interface BoardStamp {
    void changeParent(BoardStamp parent);

    void shareParent(BoardStamp parent);

    int countParents();

    boolean isGoal();

    int analyze(Heuristics heuristics);

    BoardStamp[] expose(Exposure exposure);

    void pass(Track track);
}