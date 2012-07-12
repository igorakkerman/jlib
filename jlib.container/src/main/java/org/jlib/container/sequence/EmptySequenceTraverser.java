package org.jlib.container.sequence;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.NoItemToRemoveException;

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
extends AbstractSequenceTraverser<Item, EmptySequence<Item>>
implements ObservedReplaceRemoveSequenceTraverser<Item> {

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

    @Override
    public void replace(final Item newItem)
    throws NoSequenceItemToReplaceException {
        throw new NoSequenceItemToReplaceException(getSequence());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void replace(final Item newItem, final ValueObserver<Item>... removeObservers)
    throws NoSequenceItemToReplaceException {
        throw new NoSequenceItemToReplaceException(getSequence());
    }

    @Override
    public void remove()
    throws NoItemToRemoveException {
        throw new NoSequenceItemToRemoveException(getSequence());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... observers)
    throws NoSequenceItemToRemoveException {
        throw new NoSequenceItemToRemoveException(getSequence());
    }

    @Override
    public void addReplaceObserver(final ValueObserver<Item> replaceObserver) {
        // intentionally empty: no Item to replace, hence no replacement to observe
    }
}
