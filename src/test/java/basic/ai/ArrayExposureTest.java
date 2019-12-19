package basic.ai;

import ai.BoardStamp;
import ai.Exposure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArrayExposureTest {
    private static Exposure exposure;

    @Parameterized.Parameters
    public static Collection<Object[]> testValues() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                        new BoardStamp[]{
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}),
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1}),
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1})
                        }
                },
                {
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                        new BoardStamp[]{
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1}),
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1})
                        }
                },
                {
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        new BoardStamp[]{
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}),
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1})
                        }
                },
                {
                        new int[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        new BoardStamp[]{
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}),
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}),
                                new ArrayBoardStamp(new int[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}),
                                new ArrayBoardStamp(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1})
                        }
                }
        });
    }

    private final int[] testBoardStamp;
    private final BoardStamp[] expectedBoardStamps;

    public ArrayExposureTest(int[] testBoardStamp, BoardStamp[] expectedBoardStamps) {
        this.testBoardStamp = testBoardStamp;
        this.expectedBoardStamps = expectedBoardStamps;
    }


    @Before
    public void setUp() {
        exposure = new ArrayExposure();
    }

    @After
    public void tearDown() {
        exposure = null;
    }

    @Test
    public void open() {
        BoardStamp[] boardStamps = exposure.open(testBoardStamp);
        assertEquals(expectedBoardStamps.length, boardStamps.length);
        for (int i = 0; i < expectedBoardStamps.length; ++i) {
            assertEquals(boardStamps[i], expectedBoardStamps[i]);
        }
    }
}