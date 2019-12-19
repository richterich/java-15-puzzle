package ai.decorated;

import ai.Heuristics;

public abstract class AbstractHeuristics implements Heuristics {
    private final Heuristics heuristics;

    protected AbstractHeuristics(Heuristics heuristics) {
        this.heuristics = heuristics;
    }

    @Override
    public int calculate(int[] board) {
        return heuristics.calculate(board);
    }
}
