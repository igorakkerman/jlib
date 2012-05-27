package org.jlib.container.collection;

import java.util.Iterator;

import org.jlib.container.Traverser;

/**
 * {@link Traverser} over an {@link Iterable}.
 * 
 * @param <Item>
 *        type of the items of the {@link Iterable}
 * 
 * @author Igor Akkerman
 */
public class IterableTraverser<Item>
implements Traverser<Item> {

    /** delegate {@link Iterator} */
    private final Iterator<Item> delegateIterator;

    /**
     * Creates a new {@link IterableTraverser} over the Items of the specified
     * {@link Iterable}.
     * 
     * @param iterable
     *        traversed {@link Iterable}
     */
    public IterableTraverser(final Iterable<Item> iterable) {
        super();

        delegateIterator = iterable.iterator();
    }

    @Override
    public Item next() {
        return delegateIterator.next();
    }

    @Override
    public boolean hasNext() {
        return delegateIterator.hasNext();
    }

    /**
     * Returns the delegate {@link Iterator} of this {@link IterableTraverser}.
     * 
     * @return delegate {@link Iterator}
     */
    protected Iterator<Item> getDelegateIterator() {
        return delegateIterator;
    }
}
