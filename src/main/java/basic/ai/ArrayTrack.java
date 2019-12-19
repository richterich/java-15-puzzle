package basic.ai;

import ai.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTrack implements Track {
    private final List<int[]> stamps = new ArrayList<>(100);

    @Override
    public void hold(int[] stamp) {
        stamps.add(stamp);
    }

    @Override
    public void show() {
        for (int[] stamp : stamps) {
            System.out.println(Arrays.toString(stamp));
        }
    }

    @Override
    public void clear() {
        stamps.clear();
    }
}
