package org.jlib.core.traverser;

/**
 * {@link Traversible} always providing a constant {@link Traverser}.
 * 
 * @param <Item>
 *        type of the Items traversed by the {@link Traverser}
 * 
 * @author Igor Akkerman
 */
public class ConstantTraverserTraversible<Item>
implements Traversible<Item> {

    /** returned {@link Traverser}r */
    private final Traverser<Item> traverser;

    /**
     * Creates a new {@link ConstantTraverserTraversible}.
     * 
     * @param traverser
     *        constantly returned {@link Traverser}
     */
    public ConstantTraverserTraversible(final Traverser<Item> traverser) {
        super();

        this.traverser = traverser;
    }

    @Override
    public Traverser<Item> createTraverser() {
        return traverser;
    }
}
