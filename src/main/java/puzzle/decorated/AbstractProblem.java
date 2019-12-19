package puzzle.decorated;

import puzzle.Problem;

public abstract class AbstractProblem implements Problem {
    private final Problem problem;

    protected AbstractProblem(Problem problem) {
        this.problem = problem;
    }

    @Override
    public boolean isSolvable() {
        return problem.isSolvable();
    }
}
