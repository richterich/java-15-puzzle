package basic.puzzle;


import puzzle.*;

public class BaseGame implements Game {
    private final Board board;
    private final Problem problem;
    private final Turn turn;

    public BaseGame(Board board, Problem problem, Turn turn) {
        this.board = board;
        this.problem = problem;
        this.turn = turn;
    }

    @Override
    public void load() {
        board.aline();
        board.shuffle();
        if (!problem.isSolvable()) {
            board.rotate();
        }
    }

    @Override
    public void unload() {
        board.zero();
    }

    @Override
    public void play() {
        if (turn.canAsk()) {
            turn.ask();
        }
    }
}
