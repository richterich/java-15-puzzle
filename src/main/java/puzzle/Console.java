package puzzle;

public interface Console {
    enum Direction {
        NONE,
        RIGHT,
        LEFT,
        UP,
        DOWN
    }

    Direction preferredDirection();
}
