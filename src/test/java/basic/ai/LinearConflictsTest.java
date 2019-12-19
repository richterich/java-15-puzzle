package basic.ai;

import ai.Heuristics;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LinearConflictsTest {
    private static Heuristics heuristics;

    @Parameterized.Parameters
    public static Collection<Object[]> testValues() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0},
                        0
                },
                {
                        new int[]{6, 7, 8, 5, 4, 1, 2, 3, 9, 10, 11, 12, 13, 14, 15, 0},
                        0
                },
                {
                        new int[]{1, 7, 2, 4, 5, 9, 3, 8, 6, 11, 10, 12, 13, 14, 15, 0},
                        2
                },
                {
                        new int[]{1, 2, 7, 4, 5, 9, 3, 8, 6, 11, 10, 12, 13, 14, 15, 0},
                        4
                },
                {
                        new int[]{1, 4, 3, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15},
                        6

                },
                {
                        new int[]{1, 2, 3, 4, 13, 6, 7, 8, 9, 10, 11, 12, 5, 14, 15, 0},
                        6

                },
                {
                        new int[]{3, 4, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0},
                        8
                },
                {
                        new int[]{1, 4, 3, 2, 13, 6, 7, 8, 9, 10, 11, 12, 5, 14, 15, 0},
                        12
                },
                {
                        new int[]{9, 2, 3, 4, 5, 6, 7, 8, 1, 12, 11, 10, 13, 14, 15, 0},
                        12
                }
        });
    }

    private final int[] testBoardStamp;
    private final int expectedLinearConflicts;

    public LinearConflictsTest(int[] testBoardStamp, int expectedLinearConflicts) {
        this.testBoardStamp = testBoardStamp;
        this.expectedLinearConflicts = expectedLinearConflicts;
    }

    @Before
    public void setUp() {
        final Mockery context = new Mockery();
        final Heuristics mockHeuristics = context.mock(Heuristics.class);

        context.checking(new Expectations() {{
            oneOf(mockHeuristics).calculate(testBoardStamp);
            will(returnValue(0));
        }});

        heuristics = new LinearConflicts(mockHeuristics);
    }

    @After
    public void tearDown() {
        heuristics = null;
    }

    @Test
    public void calculate() {
        assertEquals(expectedLinearConflicts, heuristics.calculate(testBoardStamp));
    }
}