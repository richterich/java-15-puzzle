package basic.ai;

import ai.Exposure;
import ai.Pathfinder;
import ai.BoardStamp;
import ai.Track;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Put start vertex into the open list;
 * Make the close list empty;
 * While the open list has value will do:
 * 	Sort the open list by F of vertices;
 * 	Make a vertex with minimal F as current vertex;
 * 	If current vertex equal goal then will return track;
 * 	Put current vertex into close list;
 * 	Delete current vertex from open list;
 * 	Find opened vertices of current vertex;
 * 	For each opened vertex:
 * 		If vertex contains close list then continue this step;
 * 		If vertex not contains open list then
 * 			put into open list opened vertices;
 * 			make current vertex as parent for opened vertex;
 * 			calculate F, G and H;
 * 		If vertex contains open list then
 * 			compare G of vertex with G of vertex in open list;
 * 			if G of vertex in opened list less then change it parent to parent of vertex;
 * 			recalculate H and G for vertex;
 */
public class ArrayPathfinder implements Pathfinder {
    private static final int TURNS = 100000;
    private static final int TOP = 0;
    private static final Comparator<BoardStamp> STAMP_COMPARATOR = new BoardStampComparator(new LinearConflicts(new ManhattanDistance()));
    private static final Exposure EXPOSURE = new ArrayExposure();
    private final Track track;
    private final List<BoardStamp> open;
    private final List<BoardStamp> closed;
    private BoardStamp goal;
    private boolean pathFound = false;

    public ArrayPathfinder(BoardStamp start, Track track) {
        this.track = track;
        (this.open = new ArrayList<>(TURNS)).add(start);
        this.closed = new ArrayList<>(TURNS);
    }

    @Override
    public boolean isDone() {
        return pathFound;
    }

    @Override
    public boolean canFind() {
        return !open.isEmpty();
    }

    @Override
    public void findNext() {
        while (!open.isEmpty()) {
            open.sort(STAMP_COMPARATOR);
            BoardStamp current = open.remove(TOP);
            if (current.isGoal()) {
                goal = current;
                pathFound = true;
                break;
            }
            closed.add(current);
            BoardStamp[] investigated = current.expose(EXPOSURE);
            for (BoardStamp node : investigated) {
                if (closed.contains(node)) continue;
                if (!open.contains(node)) {
                    open.add(node);
                } else {
                    BoardStamp already = open.get(open.indexOf(node));
                    if (node.countParents() < already.countParents()) {
                            node.shareParent(already);
                    }
                }
            }
        }
    }

    @Override
    public Track lead() {
        track.clear();
        goal.pass(track);
        return track;
    }
}
