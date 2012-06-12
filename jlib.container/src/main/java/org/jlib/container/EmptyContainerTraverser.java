package org.jlib.container;

import org.jlib.container.sequence.EmptySequence;
import org.jlib.core.traverser.BidirectionalTraverser;
import org.jlib.core.traverser.NoNextItemException;
import org.jlib.core.traverser.NoPreviousItemException;
import org.jlib.core.traverser.Traverser;

/**
 * {@link Traverser} of an {@link EmptyContainer}.
 * 
 * @param <Item>
 *        type of items potentially provided by the
 *        {@link EmptyContainerTraverser}
 * 
 * @author Igor Akkerman
 */
public class EmptyContainerTraverser<Item>
implements BidirectionalTraverser<Item> {

    /** sole {@link EmptyContainerTraverser} instance */
    private static final EmptyContainerTraverser<?> INSTANCE = new EmptyContainerTraverser<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @param <Item>
     *        type of the potential {@link EmptySequence} items
     * 
     * @return sole {@link EmptyContainerTraverser}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptyContainerTraverser<Item> getInstance() {
        return (EmptyContainerTraverser<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyContainerTraverser}.
     */
    protected EmptyContainerTraverser() {
        super();
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return false;
    }

    @Override
    public boolean isNextItemAccessible() {
        return false;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        throw new NoPreviousItemException(EmptyContainer.getInstance());
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        throw new NoNextItemException(EmptyContainer.getInstance());
    }
}
