import basic.ArrayAmbulance;
import basic.puzzle.*;
import puzzle.Envelope;
import puzzle.Sensor;
import singleplayer.SinglePlayer;
import terminal.OutTerminalTurn;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bootstrap {
    public static void main(String[] args) {
        final int attemptsAmount = -1;
        final int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final ArrayBoard arrayBoard = new ArrayBoard(board);
        final Sensor sensor = new BaseSensor(bufferedReader);
        final Envelope envelope = new ArrayEnvelope();

        new BaseGameLoop(
                new SinglePlayer(new BaseGame(
                        arrayBoard,
                        new ArrayProblem(board),
                        new OutTerminalTurn(
                                new BaseTurn(
                                        new BaseInitiator(
                                                new BaseConsole(sensor),
                                                new ArrayBlank(board)),
                                        new ArrayInspector(board),
                                        new NumberAttempts(attemptsAmount)),
                                board)),
                        arrayBoard,
                        envelope),
                sensor,
                new BaseInput(),
                new BaseState(
                        sensor,
                        new ArrayAmbulance(envelope)),
                new BaseWorld())
                .start();
    }
}
