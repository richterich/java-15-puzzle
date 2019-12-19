package basic.ai;

import ai.BoardStamp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ArrayBoardStampComparatorTest {
    private static List<BoardStamp> boardStamps;

    @Before
    public void setUp() {
        boardStamps = new ArrayList<>();
    }

    @After
    public void tearDown() {
        boardStamps = null;
    }

    @Test
    public void testComparatorSort() {
        List<BoardStamp> sortedBoardStamps = new ArrayList<>();
        sortedBoardStamps.add(new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}));
        sortedBoardStamps.add(new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}));
        sortedBoardStamps.add(new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14, 0}));
        sortedBoardStamps.add(new ArrayBoardStamp(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));

        boardStamps.add(new ArrayBoardStamp(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
        boardStamps.add(new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14, 0}));
        boardStamps.add(new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}));
        boardStamps.add(new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}));
        boardStamps.sort(new BoardStampComparator(new ManhattanDistance()));

        assertArrayEquals(sortedBoardStamps.toArray(), boardStamps.toArray());
    }
}