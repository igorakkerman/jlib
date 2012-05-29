package org.jlib.core.traverser;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
     * Creates a new {@link IterableTraverser} for the specified delegate
     * {@link Iterator}.
     * 
     * @param iterable
     *        {@link Iterable} to traverse
     */
    public IterableTraverser(final Iterable<Item> iterable) {
        super();

        delegateIterator = iterable.iterator();
    }

    @Override
    public Item getNextItem()
    throws IllegalTraverserStateException {
        try {
            return delegateIterator.next();
        }
        catch (final NoSuchElementException exception) {
            throw new NoNextItemException(exception);
        }
    }

    @Override
    public boolean hasNextItem() {
        return delegateIterator.hasNext();
    }

    /**
     * Returns the delegate {@link Iterator} of this {@link IterableTraverser}.
     * 
     * @return delegate {@link Iterator}
     */
    public Iterator<Item> getDelegateIterator() {
        return delegateIterator;
    }
}
