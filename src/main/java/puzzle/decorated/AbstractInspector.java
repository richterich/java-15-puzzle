package puzzle.decorated;

import puzzle.Inspector;

public abstract class AbstractInspector implements Inspector {
    private final Inspector inspector;

    protected AbstractInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    @Override
    public boolean isCollected() {
        return inspector.isCollected();
    }
}
