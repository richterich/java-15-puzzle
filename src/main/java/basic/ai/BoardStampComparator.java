package basic.ai;

import ai.Heuristics;
import ai.BoardStamp;

import java.util.Comparator;

public class BoardStampComparator implements Comparator<BoardStamp> {
    private final Heuristics HEURISTICS;

    public BoardStampComparator(Heuristics heuristics) {
        HEURISTICS = heuristics;
    }

    @Override
    public int compare(BoardStamp boardStamp, BoardStamp t1) {
        int f1 = boardStamp.analyze(HEURISTICS);
        int f2 = t1.analyze(HEURISTICS);
        if (f1 > f2) return 1;
        else if (f1 == f2) return 0;
        return -1;
    }
}
