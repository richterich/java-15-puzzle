package basic.puzzle;

import puzzle.Sensor;

import java.io.BufferedReader;
import java.io.IOException;

public class BaseSensor implements Sensor {
    private final BufferedReader reader;
    private String line;

    public BaseSensor(BufferedReader reader) {
        this.reader = reader;
        line = "";
    }

    @Override
    public void listen() {
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int respond() {
        switch (line) {
            case "W":
            case "w":
                return 1000;
            case "A":
            case "a":
                return 1100;
            case "S":
            case "s":
                return 1110;
            case "D":
            case "d":
                return 1111;
            case "C":
            case "c":
                return 1;
            case "Q":
            case "q":
                return 0;
            case "N":
            case "n":
                return 5;
            default:
                return -1;
        }
    }
}
