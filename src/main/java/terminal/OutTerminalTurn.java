package terminal;

import puzzle.Turn;
import puzzle.decorated.AbstractTurn;

public class OutTerminalTurn extends AbstractTurn {
    private final int[] board;
    private final StringBuilder tiles = new StringBuilder(38);

    public OutTerminalTurn(Turn turn, int[] board) {
        super(turn);
        this.board = board;
    }

    @Override
    public void ask() {
        out();
        super.ask();
    }

    private void out() {
        tiles.delete(0, tiles.length());
        tiles
                .append(board[0]).append('\t').append(board[1]).append('\t').append(board[2]).append('\t').append(board[3]).append('\n')
                .append(board[4]).append('\t').append(board[5]).append('\t').append(board[6]).append('\t').append(board[7]).append('\n')
                .append(board[8]).append('\t').append(board[9]).append('\t').append(board[10]).append('\t').append(board[11]).append('\n')
                .append(board[12]).append('\t').append(board[13]).append('\t').append(board[14]).append('\t').append(board[15]).append('\n');
        System.out.println(tiles.toString());
    }
}
