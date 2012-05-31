package org.jlib.container.sequence;

import org.jlib.container.sequence.index.IndexSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} of an {@link EmptySequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class EmptySequenceTraverser<Item>
extends AbstractSequenceTraverser<Item, EmptySequence<Item>> {

    /** sole instance of this class */
    private static final EmptySequenceTraverser<?> INSTANCE = new EmptySequenceTraverser<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link EmptySequenceTraverser}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptySequenceTraverser<Item> getInstance() {
        return (EmptySequenceTraverser<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequenceTraverser}.
     */
    protected EmptySequenceTraverser() {
        super(EmptySequence.<Item> getInstance());
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
        throw new NoPreviousItemException(getSequence());
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        throw new NoNextItemException(getSequence());
    }
}
