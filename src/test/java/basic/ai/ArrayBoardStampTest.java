package basic.ai;

import ai.BoardStamp;
import ai.Exposure;
import ai.Heuristics;
import ai.Track;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayBoardStampTest {
    private static BoardStamp boardStamp;

    @Test
    public void testEquals_Equal() {
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});

        assertEquals(boardStamp, boardStamp);
        assertEquals(boardStamp, new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}));
    }

    @Test
    public void testEquals_NotEqual() {
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});

        assertNotEquals(boardStamp, null);
        assertNotEquals(boardStamp, new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14, 0}));
        assertNotEquals(boardStamp, new ArrayBoardStamp(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
        assertNotEquals(boardStamp, new ArrayBoardStamp(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 15, 14, 13, 12, 11, 10}));
    }

    @Test
    public void testChangeParent_WithoutEqual() throws NoSuchFieldException, IllegalAccessException {
        final Field parentField = ArrayBoardStamp.class.getDeclaredField("parent");
        parentField.setAccessible(true);

        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        final BoardStamp otherBoardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15});
        boardStamp.changeParent(otherBoardStamp);
        assertEquals(otherBoardStamp, parentField.get(boardStamp));
    }

    @Test
    public void testChangeParent_WithEqual() throws NoSuchFieldException, IllegalAccessException {
        final Field parentField = ArrayBoardStamp.class.getDeclaredField("parent");
        parentField.setAccessible(true);

        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        final BoardStamp equalBoardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        boardStamp.changeParent(equalBoardStamp);
        assertNull(parentField.get(boardStamp));
    }

    @Test
    public void testShareParent_WithoutEqual() throws NoSuchFieldException, IllegalAccessException {
        final Field parentField = ArrayBoardStamp.class.getDeclaredField("parent");
        parentField.setAccessible(true);

        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        final BoardStamp parentSender = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15});
        final BoardStamp parentReceiver = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 14, 15});

        parentField.set(parentSender, boardStamp);

        parentSender.shareParent(parentReceiver);

        assertNull(parentField.get(boardStamp));
        assertEquals(boardStamp, parentField.get(parentSender));
        assertEquals(boardStamp, parentField.get(parentReceiver));
    }

    @Test
    public void testShareParent_WithEqual() throws NoSuchFieldException, IllegalAccessException {
        final Field parentField = ArrayBoardStamp.class.getDeclaredField("parent");
        parentField.setAccessible(true);

        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        final BoardStamp parentSender = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15});
        final BoardStamp parentReceiver = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});

        parentField.set(parentSender, boardStamp);

        parentSender.shareParent(parentReceiver);

        assertNull(parentField.get(boardStamp));
        assertEquals(boardStamp, parentField.get(parentSender));
        assertNull(parentField.get(parentReceiver));
    }

    @Test
    public void testCountParents() throws NoSuchFieldException, IllegalAccessException {
        final Field parentField = ArrayBoardStamp.class.getDeclaredField("parent");
        parentField.setAccessible(true);

        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        final BoardStamp boardStamp1 = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15});
        final BoardStamp boardStamp2 = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 14, 15});
        final BoardStamp boardStamp3 = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15});

        parentField.set(boardStamp1, boardStamp);
        parentField.set(boardStamp2, boardStamp1);
        parentField.set(boardStamp3, boardStamp2);

        assertEquals(0, boardStamp.countParents());
        assertEquals(1, boardStamp1.countParents());
        assertEquals(2, boardStamp2.countParents());
        assertEquals(3, boardStamp3.countParents());

        parentField.set(boardStamp3, boardStamp1);

        assertEquals(2, boardStamp2.countParents());
        assertEquals(2, boardStamp3.countParents());
    }

    @Test
    public void testIsGoal_Goal() {
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        assertTrue(boardStamp.isGoal());
    }

    @Test
    public void testIsGoal_NotGoal() {
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 0, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
        boardStamp = new ArrayBoardStamp(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        assertFalse(boardStamp.isGoal());
    }

    @Test
    public void testAnalyze() {
        final int analyzeValue = 10;
        final int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        final Mockery context = new Mockery();
        final Heuristics mockHeuristics = context.mock(Heuristics.class);

        context.checking(new Expectations() {{
            oneOf(mockHeuristics).calculate(board);
            will(returnValue(analyzeValue));
        }});

        boardStamp = new ArrayBoardStamp(board);
        assertEquals(analyzeValue, boardStamp.analyze(mockHeuristics));
    }

    @Test
    public void testExpose_Amount() {
        final BoardStamp[] exposeValue = new BoardStamp[]{
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15}),
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 14, 15}),
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15}),
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 12, 13, 14, 15})
        };
        final int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        final Mockery context = new Mockery();
        final Exposure mockExposure = context.mock(Exposure.class);

        context.checking(new Expectations() {{
            oneOf(mockExposure).open(board);
            will(returnValue(exposeValue));
        }});

        boardStamp = new ArrayBoardStamp(board);
        assertArrayEquals(exposeValue, boardStamp.expose(mockExposure));
    }

    @Test
    public void testExpose_Parent() throws NoSuchFieldException, IllegalAccessException {
        final BoardStamp[] exposeValue = new BoardStamp[]{
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15}),
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 14, 15}),
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15}),
                new ArrayBoardStamp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 12, 13, 14, 15})
        };
        final int[] board = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        final Mockery context = new Mockery();
        final Exposure mockExposure = context.mock(Exposure.class);

        final Field parentField = ArrayBoardStamp.class.getDeclaredField("parent");
        parentField.setAccessible(true);

        context.checking(new Expectations() {{
            oneOf(mockExposure).open(board);
            will(returnValue(exposeValue));
        }});

        boardStamp = new ArrayBoardStamp(board);
        boardStamp.expose(mockExposure);

        for (BoardStamp stamp: exposeValue) {
            assertEquals(boardStamp, parentField.get(stamp));
        }
    }

    @Test
    public void testPass() throws NoSuchFieldException, IllegalAccessException {
        final List<int[]> testStampsValues = new ArrayList<int[]>() {{
            add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
            add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0, 15});
            add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 14, 15});
            add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15});
        }};
        final Track track = new ArrayTrack();
        final Field parentField = ArrayBoardStamp.class.getDeclaredField("parent");
        final Field stampsField = ArrayTrack.class.getDeclaredField("stamps");

        parentField.setAccessible(true);
        stampsField.setAccessible(true);

        boardStamp = new ArrayBoardStamp(testStampsValues.get(0));
        final BoardStamp boardStamp1 = new ArrayBoardStamp(testStampsValues.get(1));
        final BoardStamp boardStamp2 = new ArrayBoardStamp(testStampsValues.get(2));
        final BoardStamp boardStamp3 = new ArrayBoardStamp(testStampsValues.get(3));

        parentField.set(boardStamp1, boardStamp);
        parentField.set(boardStamp2, boardStamp1);
        parentField.set(boardStamp3, boardStamp2);

        boardStamp3.pass(track);

        assertArrayEquals(testStampsValues.toArray(), ((ArrayList) stampsField.get(track)).toArray());
    }
}