package org.jlib.container.sequence;

import org.jlib.container.sequence.index.IndexSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} of an {@link EmptySequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link EmptySequence}
 * 
 * @author Igor Akkerman
 */
public class EmptySequenceTraverser<Item>
extends AbstractSequenceTraverser<Item, EmptySequence<Item>> {

    /** sole {@link EmptySequenceTraverser} instance */
    private static final EmptySequenceTraverser<?> INSTANCE = new EmptySequenceTraverser<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @param <Item>
     *        type of the potential {@link EmptySequence} items
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
    throws NoPreviousSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        throw new NoNextSequenceItemException(getSequence());
    }
}
