package basic.ai;

import ai.Heuristics;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ManhattanDistanceTest {
    private static Heuristics heuristics;

    @Parameterized.Parameters
    public static Collection<Object[]> testValues() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0},
                        0
                },
                {
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15},
                        1

                },
                {
                        new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                        24

                },
                {
                        new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1},
                        6
                }
        });
    }

    private final int[] testBoardStamp;
    private final int expectedManhattanDistance;

    public ManhattanDistanceTest(int[] testBoardStamp, int expectedManhattanDistance) {
        this.testBoardStamp = testBoardStamp;
        this.expectedManhattanDistance = expectedManhattanDistance;
    }

    @Before
    public void setUp() {
        heuristics = new ManhattanDistance();
    }

    @After
    public void tearDown() {
        heuristics = null;
    }

    @Test
    public void calculate() {
        assertEquals(expectedManhattanDistance, heuristics.calculate(testBoardStamp));
    }
}